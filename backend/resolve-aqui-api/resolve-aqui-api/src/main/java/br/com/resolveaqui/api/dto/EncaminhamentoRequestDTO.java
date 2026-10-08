package br.com.resolveaqui.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EncaminhamentoRequestDTO(

        @NotBlank(message = "Observação é obrigatória")
        String observacao,

        @NotNull(message = "ID da ocorrência é obrigatório")
        Long ocorrenciaId,

        @NotNull(message = "ID do órgão é obrigatório")
        Long orgaoId

) {
}