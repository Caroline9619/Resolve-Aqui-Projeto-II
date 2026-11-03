
package br.com.resolveaqui.api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.resolveaqui.api.model.PerfilUsuario;
import br.com.resolveaqui.api.model.Usuario;
import br.com.resolveaqui.api.repository.UsuarioRepository;

@Configuration
@Profile("dev")
public class DadosIniciais {

    @Bean
    CommandLineRunner cadastrarUsuariosDeTeste(
            UsuarioRepository repository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            criarUsuario(repository, passwordEncoder,
                    "Gestor do Sistema",
                    "gestor@resolveaqui.com",
                    "11122233344",
                    PerfilUsuario.GESTOR);

            criarUsuario(repository, passwordEncoder,
                    "Servidor Municipal",
                    "servidor@resolveaqui.com",
                    "22233344455",
                    PerfilUsuario.SERVIDOR);

            criarUsuario(repository, passwordEncoder,
                    "Cidadao de Teste",
                    "cidadao@resolveaqui.com",
                    "33344455566",
                    PerfilUsuario.CIDADAO);
        };
    }

    private void criarUsuario(
            UsuarioRepository repository,
            PasswordEncoder passwordEncoder,
            String nome,
            String email,
            String cpf,
            PerfilUsuario perfil) {

        if (repository.existsByEmail(email)) {
            return;
        }

        Usuario usuario = new Usuario(
                nome,
                email,
                cpf,
                "86999999999",
                passwordEncoder.encode("Teste@123")
        );

        usuario.setPerfil(perfil);

        repository.save(usuario);
    }
}
