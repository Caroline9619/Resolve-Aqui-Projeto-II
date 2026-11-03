
package br.com.resolveaqui.api.security;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.resolveaqui.api.model.Usuario;
import br.com.resolveaqui.api.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            UsuarioRepository usuarioRepository) {

        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String cabecalho = request.getHeader("Authorization");

        if (cabecalho == null || !cabecalho.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = cabecalho.substring(7);

        try {
            if (jwtService.validarToken(token)
                    && SecurityContextHolder.getContext().getAuthentication() == null) {

                String email = jwtService.extrairEmail(token);

                Optional<Usuario> usuarioEncontrado =
                        usuarioRepository.findByEmail(email);

                if (usuarioEncontrado.isPresent()) {

                    Usuario usuario = usuarioEncontrado.get();

                    var autoridade = new SimpleGrantedAuthority(
                            "ROLE_" + usuario.getPerfil().name()
                    );

                    var autenticacao =
                            new UsernamePasswordAuthenticationToken(
                                    usuario,
                                    null,
                                    List.of(autoridade)
                            );

                    autenticacao.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request)
                    );

                    SecurityContextHolder.getContext()
                            .setAuthentication(autenticacao);
                            System.out.println("USUÁRIO AUTENTICADO: " + usuario.getEmail());
System.out.println("PERFIL DO USUÁRIO: " + usuario.getPerfil());
System.out.println("AUTORIDADE: " + autoridade.getAuthority());
                }
            }

        } catch (Exception e) {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}
