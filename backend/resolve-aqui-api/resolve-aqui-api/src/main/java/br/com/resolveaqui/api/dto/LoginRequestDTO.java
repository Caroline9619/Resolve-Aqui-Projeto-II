
package br.com.resolveaqui.api.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(

    @NotBlank(message = "Informe seu e-mail ou CPF")
    String identificador,

    @NotBlank(message = "Informe sua senha")
    String senha

) {}
