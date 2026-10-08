package br.com.resolveaqui.api.dto;

import br.com.resolveaqui.api.model.Encaminhamento;

import java.time.LocalDateTime;

public record EncaminhamentoResponseDTO(
        Long id,
        String observacao,
        LocalDateTime dataEncaminhamento,
        Long ocorrenciaId,
        Long orgaoId
) {

    public static EncaminhamentoResponseDTO fromEntity(
            Encaminhamento encaminhamento) {

        return new EncaminhamentoResponseDTO(
                encaminhamento.getId(),
                encaminhamento.getObservacao(),
                encaminhamento.getDataEncaminhamento(),
                encaminhamento.getOcorrencia().getId(),
                encaminhamento.getOrgao().getId()
        );
    }
}