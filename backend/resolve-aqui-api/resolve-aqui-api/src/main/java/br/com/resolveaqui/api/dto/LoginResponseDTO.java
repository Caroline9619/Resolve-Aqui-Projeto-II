
package br.com.resolveaqui.api.dto;

import br.com.resolveaqui.api.model.PerfilUsuario;
import br.com.resolveaqui.api.model.Usuario;

public record LoginResponseDTO(
        Long id,
        String nome,
        String email,
        PerfilUsuario perfil,
        String token
) {

    public static LoginResponseDTO fromEntity(
            Usuario usuario,
            String token) {

        return new LoginResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPerfil(),
                token
        );
    }
}
