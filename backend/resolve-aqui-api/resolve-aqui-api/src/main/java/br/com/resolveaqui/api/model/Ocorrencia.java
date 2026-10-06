package br.com.resolveaqui.api.model;

import jakarta.persistence.*;
import br.com.resolveaqui.api.enums.Prioridade;

@Entity
@Table(name = "ocorrencias")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(length = 100)
    private String categoria;

    @Column(length = 200)
    private String localizacao;

    @Column(length = 500)
    private String fotoVideo;

    @Enumerated(EnumType.STRING)
@Column(nullable = false, length = 20)
private Prioridade prioridade;

    @Column(nullable = false, length = 30)
    private String status;

    @ManyToOne
@JoinColumn(name = "usuario_id", nullable = false)
private Usuario usuario;

    public Ocorrencia() {
    }

    public Ocorrencia(
        String titulo,
        String descricao,
        String categoria,
        String localizacao,
        String fotoVideo,
        Prioridade prioridade,
        String status,
        Usuario usuario) {

    this.titulo = titulo;
    this.descricao = descricao;
    this.categoria = categoria;
    this.localizacao = localizacao;
    this.fotoVideo = fotoVideo;
    this.prioridade = prioridade;
    this.status = status;
    this.usuario = usuario;
}

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getFotoVideo() {
        return fotoVideo;
    }

    public void setFotoVideo(String fotoVideo) {
        this.fotoVideo = fotoVideo;
    }

    public Prioridade getPrioridade() {
    return prioridade;
}

    public void setPrioridade(Prioridade prioridade) {
    this.prioridade = prioridade;
}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Usuario getUsuario() {
    return usuario;
}

public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
}
}