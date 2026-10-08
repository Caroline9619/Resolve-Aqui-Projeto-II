package br.com.resolveaqui.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "conclusoes_ocorrencias")
public class ConclusaoOcorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String resultado;

    @Column(nullable = false)
    private LocalDateTime dataConclusao;

    @OneToOne
    @JoinColumn(name = "ocorrencia_id", nullable = false)
    private Ocorrencia ocorrencia;

    public ConclusaoOcorrencia() {
    }

    public ConclusaoOcorrencia(
            String resultado,
            LocalDateTime dataConclusao,
            Ocorrencia ocorrencia) {

        this.resultado = resultado;
        this.dataConclusao = dataConclusao;
        this.ocorrencia = ocorrencia;
    }

    public Long getId() {
        return id;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
}