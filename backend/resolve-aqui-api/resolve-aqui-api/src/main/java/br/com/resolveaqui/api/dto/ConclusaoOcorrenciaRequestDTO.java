package br.com.resolveaqui.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ConclusaoOcorrenciaRequestDTO(

        @NotBlank(message = "Resultado da conclusão é obrigatório")
        String resultado,

        @NotNull(message = "ID da ocorrência é obrigatório")
        Long ocorrenciaId

) {
}