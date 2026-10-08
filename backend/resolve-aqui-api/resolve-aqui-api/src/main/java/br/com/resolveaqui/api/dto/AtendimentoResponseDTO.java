package br.com.resolveaqui.api.dto;

import br.com.resolveaqui.api.model.Atendimento;
import java.time.LocalDateTime;

public record AtendimentoResponseDTO(
        Long id,
        String descricao,
        LocalDateTime dataAtendimento,
        Long ocorrenciaId
) {

    public static AtendimentoResponseDTO fromEntity(
            Atendimento atendimento) {

        return new AtendimentoResponseDTO(
                atendimento.getId(),
                atendimento.getDescricao(),
                atendimento.getDataAtendimento(),
                atendimento.getOcorrencia().getId()
        );
    }
}