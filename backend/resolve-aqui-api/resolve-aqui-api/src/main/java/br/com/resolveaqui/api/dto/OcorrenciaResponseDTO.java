package br.com.resolveaqui.api.dto;

import br.com.resolveaqui.api.enums.Prioridade;
import br.com.resolveaqui.api.model.Ocorrencia;
import br.com.resolveaqui.api.enums.StatusOcorrencia;

public record OcorrenciaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        String categoria,
        String localizacao,
        String fotoVideo,
        Prioridade prioridade,
        StatusOcorrencia status,
        Long usuarioId,
        Long orgaoId
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
                ocorrencia.getUsuario().getId(),
                ocorrencia.getOrgao() != null
                        ? ocorrencia.getOrgao().getId()
                        : null
        );
    }
}