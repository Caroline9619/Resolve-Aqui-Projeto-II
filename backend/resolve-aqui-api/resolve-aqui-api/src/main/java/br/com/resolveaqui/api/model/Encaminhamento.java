package br.com.resolveaqui.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "encaminhamentos")
public class Encaminhamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String observacao;

    @Column(nullable = false)
    private LocalDateTime dataEncaminhamento;

    @ManyToOne
    @JoinColumn(name = "ocorrencia_id", nullable = false)
    private Ocorrencia ocorrencia;

    @ManyToOne
    @JoinColumn(name = "orgao_id", nullable = false)
    private Orgao orgao;

    public Encaminhamento() {
    }

    public Encaminhamento(
            String observacao,
            LocalDateTime dataEncaminhamento,
            Ocorrencia ocorrencia,
            Orgao orgao) {

        this.observacao = observacao;
        this.dataEncaminhamento = dataEncaminhamento;
        this.ocorrencia = ocorrencia;
        this.orgao = orgao;
    }

    public Long getId() {
        return id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDateTime getDataEncaminhamento() {
        return dataEncaminhamento;
    }

    public void setDataEncaminhamento(LocalDateTime dataEncaminhamento) {
        this.dataEncaminhamento = dataEncaminhamento;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }
}