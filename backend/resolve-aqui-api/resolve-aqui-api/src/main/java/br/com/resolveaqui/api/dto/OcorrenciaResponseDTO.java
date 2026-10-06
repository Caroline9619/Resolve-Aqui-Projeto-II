package br.com.resolveaqui.api.dto;

import br.com.resolveaqui.api.model.Ocorrencia;

public record OcorrenciaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        String categoria,
        String localizacao,
        String fotoVideo,
        String prioridade,
        String status,
        Long usuarioId
) {

    public static OcorrenciaResponseDTO fromEntity(Ocorrencia ocorrencia) {

        return new OcorrenciaResponseDTO(
                ocorrencia.getId(),
                ocorrencia.getTitulo(),
                ocorrencia.getDescricao(),
                ocorrencia.getCategoria(),
                ocorrencia.getLocalizacao(),
                ocorrencia.getFotoVideo(),
                ocorrencia.getPrioridade(),
                ocorrencia.getStatus(),
                ocorrencia.getUsuario().getId()
        );
    }
}