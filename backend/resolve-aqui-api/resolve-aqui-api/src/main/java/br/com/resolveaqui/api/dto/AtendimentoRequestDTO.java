package br.com.resolveaqui.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtendimentoRequestDTO(

        @NotBlank(message = "Descrição do atendimento é obrigatória")
        String descricao,

        @NotNull(message = "ID da ocorrência é obrigatório")
        Long ocorrenciaId

) {
}