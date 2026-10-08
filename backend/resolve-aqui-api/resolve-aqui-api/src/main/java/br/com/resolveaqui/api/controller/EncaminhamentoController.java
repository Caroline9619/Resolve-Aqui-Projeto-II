package br.com.resolveaqui.api.controller;

import br.com.resolveaqui.api.dto.EncaminhamentoRequestDTO;
import br.com.resolveaqui.api.dto.EncaminhamentoResponseDTO;
import br.com.resolveaqui.api.service.EncaminhamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encaminhamentos")
public class EncaminhamentoController {

    private final EncaminhamentoService service;

    public EncaminhamentoController(
            EncaminhamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EncaminhamentoResponseDTO> cadastrar(
            @Valid @RequestBody EncaminhamentoRequestDTO dto) {

        EncaminhamentoResponseDTO encaminhamento =
                service.cadastrar(dto);

        return ResponseEntity.ok(encaminhamento);
    }

    @GetMapping
    public ResponseEntity<List<EncaminhamentoResponseDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }
}