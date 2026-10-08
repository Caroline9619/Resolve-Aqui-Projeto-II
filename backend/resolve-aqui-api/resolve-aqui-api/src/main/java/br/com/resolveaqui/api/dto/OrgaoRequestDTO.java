package br.com.resolveaqui.api.dto;

import jakarta.validation.constraints.NotBlank;

public record OrgaoRequestDTO(

        @NotBlank(message = "Nome do órgão é obrigatório")
        String nome,

        @NotBlank(message = "Secretaria é obrigatória")
        String secretaria,

        String descricao

) {
}