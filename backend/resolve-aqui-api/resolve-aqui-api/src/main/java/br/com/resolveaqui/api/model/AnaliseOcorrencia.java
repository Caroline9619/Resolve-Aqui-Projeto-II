package br.com.resolveaqui.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "analises_ocorrencias")
public class AnaliseOcorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String resultado;

    @Column(length = 1000)
    private String observacao;

    @Column(nullable = false)
    private LocalDateTime dataAnalise;

    @OneToOne
    @JoinColumn(name = "ocorrencia_id", nullable = false)
    private Ocorrencia ocorrencia;

    public AnaliseOcorrencia() {
    }

    public AnaliseOcorrencia(
            String resultado,
            String observacao,
            LocalDateTime dataAnalise,
            Ocorrencia ocorrencia) {

        this.resultado = resultado;
        this.observacao = observacao;
        this.dataAnalise = dataAnalise;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDateTime getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDateTime dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
}