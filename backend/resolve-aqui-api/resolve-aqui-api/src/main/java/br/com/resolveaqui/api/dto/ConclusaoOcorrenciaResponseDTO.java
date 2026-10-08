package br.com.resolveaqui.api.dto;

import br.com.resolveaqui.api.model.ConclusaoOcorrencia;

import java.time.LocalDateTime;

public record ConclusaoOcorrenciaResponseDTO(
        Long id,
        String resultado,
        LocalDateTime dataConclusao,
        Long ocorrenciaId
) {

    public static ConclusaoOcorrenciaResponseDTO fromEntity(
            ConclusaoOcorrencia conclusao) {

        return new ConclusaoOcorrenciaResponseDTO(
                conclusao.getId(),
                conclusao.getResultado(),
                conclusao.getDataConclusao(),
                conclusao.getOcorrencia().getId()
        );
    }
}