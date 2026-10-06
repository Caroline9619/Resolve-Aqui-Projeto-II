package br.com.resolveaqui.api.controller;

import br.com.resolveaqui.api.dto.UsuarioRequestDTO;
import br.com.resolveaqui.api.dto.UsuarioResponseDTO;
import br.com.resolveaqui.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(
            @Valid @RequestBody UsuarioRequestDTO dto) {

        UsuarioResponseDTO usuario = service.cadastrar(dto);

        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }
}