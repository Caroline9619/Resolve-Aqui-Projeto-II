package br.com.resolveaqui.api.controller;

import br.com.resolveaqui.api.dto.ConclusaoOcorrenciaRequestDTO;
import br.com.resolveaqui.api.dto.ConclusaoOcorrenciaResponseDTO;
import br.com.resolveaqui.api.service.ConclusaoOcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conclusoes")
public class ConclusaoOcorrenciaController {

    private final ConclusaoOcorrenciaService service;

    public ConclusaoOcorrenciaController(
            ConclusaoOcorrenciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ConclusaoOcorrenciaResponseDTO> cadastrar(
            @Valid @RequestBody ConclusaoOcorrenciaRequestDTO dto) {

        ConclusaoOcorrenciaResponseDTO conclusao =
                service.cadastrar(dto);

        return ResponseEntity.ok(conclusao);
    }

    @GetMapping
    public ResponseEntity<List<ConclusaoOcorrenciaResponseDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }
}
