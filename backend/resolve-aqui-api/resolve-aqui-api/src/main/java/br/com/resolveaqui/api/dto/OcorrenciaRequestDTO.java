package br.com.resolveaqui.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OcorrenciaRequestDTO(

        @NotBlank(message = "Título é obrigatório")
        String titulo,

        @NotBlank(message = "Descrição é obrigatória")
        String descricao,

        @NotBlank(message = "Categoria é obrigatória")
        String categoria,

        @NotBlank(message = "Localização é obrigatória")
        String localizacao,

        String fotoVideo,

        @NotBlank(message = "Prioridade é obrigatória")
        String prioridade,

        @NotNull(message = "ID do usuário é obrigatório")
        Long usuarioId,

        Long orgaoId

) {
}