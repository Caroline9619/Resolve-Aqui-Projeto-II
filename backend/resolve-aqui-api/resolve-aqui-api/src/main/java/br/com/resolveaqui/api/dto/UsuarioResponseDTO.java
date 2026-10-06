package br.com.resolveaqui.api.dto;

import br.com.resolveaqui.api.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String cpf,
        String celular
) {

    public static UsuarioResponseDTO fromEntity(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getCelular()
        );
    }
}