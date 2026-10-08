package br.com.resolveaqui.api.dto;

import br.com.resolveaqui.api.model.AnaliseOcorrencia;

import java.time.LocalDateTime;

public record AnaliseOcorrenciaResponseDTO(
        Long id,
        String resultado,
        String observacao,
        LocalDateTime dataAnalise,
        Long ocorrenciaId
) {

    public static AnaliseOcorrenciaResponseDTO fromEntity(
            AnaliseOcorrencia analise) {

        return new AnaliseOcorrenciaResponseDTO(
                analise.getId(),
                analise.getResultado(),
                analise.getObservacao(),
                analise.getDataAnalise(),
                analise.getOcorrencia().getId()
        );
    }
}