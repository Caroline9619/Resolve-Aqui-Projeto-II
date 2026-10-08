package br.com.resolveaqui.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnaliseOcorrenciaRequestDTO(

        @NotBlank(message = "Resultado da análise é obrigatório")
        String resultado,

        String observacao,

        @NotNull(message = "ID da ocorrência é obrigatório")
        Long ocorrenciaId

) {
}