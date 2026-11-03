
package br.com.resolveaqui.api.security;

import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.resolveaqui.api.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final SecretKey chaveSecreta;
    private final long tempoExpiracao;

    public JwtService(
            @Value("${jwt.secret}") String segredo,
            @Value("${jwt.expiration}") long tempoExpiracao) {

        this.chaveSecreta = Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(segredo)
        );

        this.tempoExpiracao = tempoExpiracao;
    }

    // Gera um token para o usuário que realizou login
    public String gerarToken(Usuario usuario) {

        Date agora = new Date();

        Date expiracao = new Date(
                agora.getTime() + tempoExpiracao
        );

        return Jwts.builder()
                .subject(usuario.getEmail())
                .claim("id", usuario.getId())
                .claim("perfil", usuario.getPerfil().name())
                .issuedAt(agora)
                .expiration(expiracao)
                .signWith(chaveSecreta)
                .compact();
    }

    // Verifica se o token é válido
    public boolean validarToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(chaveSecreta)
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    // Recupera o e-mail armazenado no token
    public String extrairEmail(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(chaveSecreta)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }
}
