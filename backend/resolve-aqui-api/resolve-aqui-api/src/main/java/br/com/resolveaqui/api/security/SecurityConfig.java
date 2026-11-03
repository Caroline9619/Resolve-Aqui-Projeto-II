
package br.com.resolveaqui.api.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))

            .csrf(csrf -> csrf.disable())

            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth

    // Acesso público
    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
    .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
    .requestMatchers(HttpMethod.POST, "/api/usuarios/login").permitAll()
    .requestMatchers("/h2-console/**").permitAll()

    // Cidadão, servidor e gestor
    .requestMatchers(HttpMethod.GET, "/api/orgaos").hasAnyRole("CIDADAO", "SERVIDOR", "GESTOR")

    // Cidadão
    .requestMatchers(HttpMethod.POST, "/api/ocorrencias").hasRole("CIDADAO")
    .requestMatchers(HttpMethod.GET, "/api/ocorrencias/minhas").hasRole("CIDADAO")

    // Servidor e gestor
    .requestMatchers("/api/analises/**").hasAnyRole("SERVIDOR", "GESTOR")
    .requestMatchers("/api/atendimentos/**").hasAnyRole("SERVIDOR", "GESTOR")
    .requestMatchers("/api/conclusoes/**").hasAnyRole("SERVIDOR", "GESTOR")
    .requestMatchers("/api/encaminhamentos/**").hasAnyRole("SERVIDOR", "GESTOR")
    .requestMatchers(HttpMethod.GET, "/api/ocorrencias").hasAnyRole("SERVIDOR", "GESTOR")

    // Somente gestor
    .requestMatchers("/api/usuarios/**").hasRole("GESTOR")
    .requestMatchers(HttpMethod.POST, "/api/orgaos").hasRole("GESTOR")

    // Demais rotas exigem autenticação
    .anyRequest().authenticated()
)

            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin())
            )

            .formLogin(form -> form.disable())

            .httpBasic(basic -> basic.disable())

            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of(
            "http://127.0.0.1:5500",
            "http://localhost:5500"
        ));

        configuration.setAllowedMethods(List.of(
            "GET", "POST", "PUT", "PATCH",
            "DELETE", "OPTIONS"
        ));

        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
