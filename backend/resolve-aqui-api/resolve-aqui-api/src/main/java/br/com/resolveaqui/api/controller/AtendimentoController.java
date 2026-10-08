package br.com.resolveaqui.api.controller;

import br.com.resolveaqui.api.dto.AtendimentoRequestDTO;
import br.com.resolveaqui.api.dto.AtendimentoResponseDTO;
import br.com.resolveaqui.api.service.AtendimentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {

    private final AtendimentoService service;

    public AtendimentoController(AtendimentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AtendimentoResponseDTO> cadastrar(
            @Valid @RequestBody AtendimentoRequestDTO dto) {

        AtendimentoResponseDTO atendimento =
                service.cadastrar(dto);

        return ResponseEntity.ok(atendimento);
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoResponseDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }
}