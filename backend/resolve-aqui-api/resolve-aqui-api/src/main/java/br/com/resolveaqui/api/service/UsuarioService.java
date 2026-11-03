package br.com.resolveaqui.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.resolveaqui.api.dto.LoginRequestDTO;
import br.com.resolveaqui.api.dto.LoginResponseDTO;
import br.com.resolveaqui.api.dto.UsuarioRequestDTO;
import br.com.resolveaqui.api.dto.UsuarioResponseDTO;
import br.com.resolveaqui.api.model.Usuario;
import br.com.resolveaqui.api.repository.UsuarioRepository;
import br.com.resolveaqui.api.security.JwtService;


@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

   public UsuarioService(
        UsuarioRepository repository,
        PasswordEncoder passwordEncoder,
        JwtService jwtService) {

    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
}

    @Transactional
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {

        if (repository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        if (repository.existsByCpf(dto.cpf())) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }

        String senhaCriptografada = passwordEncoder.encode(dto.senha());

        Usuario usuario = new Usuario(
                dto.nome(),
                dto.email(),
                dto.cpf(),
                dto.celular(),
                senhaCriptografada
        );

        Usuario usuarioSalvo = repository.save(usuario);

        return UsuarioResponseDTO.fromEntity(usuarioSalvo);
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(UsuarioResponseDTO::fromEntity)
                .toList();
    }
    @Transactional(readOnly = true)
public LoginResponseDTO login(LoginRequestDTO dto) {

    String identificador = dto.identificador().trim();

    Optional<Usuario> usuarioEncontrado =
            repository.findByEmail(identificador);

    if (usuarioEncontrado.isEmpty()) {
        usuarioEncontrado = repository.findByCpf(identificador);
    }

    Usuario usuario = usuarioEncontrado.orElseThrow(
            () -> new IllegalArgumentException(
                    "E-mail, CPF ou senha inválidos."
            )
    );

    boolean senhaCorreta = passwordEncoder.matches(
            dto.senha(),
            usuario.getSenha()
    );

    if (!senhaCorreta) {
        throw new IllegalArgumentException(
                "E-mail, CPF ou senha inválidos."
        );
    }

    String token = jwtService.gerarToken(usuario);

return LoginResponseDTO.fromEntity(usuario, token);
}
}
