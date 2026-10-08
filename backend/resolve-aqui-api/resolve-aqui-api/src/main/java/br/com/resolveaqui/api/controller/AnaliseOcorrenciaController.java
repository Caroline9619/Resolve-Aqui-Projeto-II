package br.com.resolveaqui.api.controller;

import br.com.resolveaqui.api.dto.AnaliseOcorrenciaRequestDTO;
import br.com.resolveaqui.api.dto.AnaliseOcorrenciaResponseDTO;
import br.com.resolveaqui.api.service.AnaliseOcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analises")
public class AnaliseOcorrenciaController {

    private final AnaliseOcorrenciaService service;

    public AnaliseOcorrenciaController(
            AnaliseOcorrenciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AnaliseOcorrenciaResponseDTO> cadastrar(
            @Valid @RequestBody AnaliseOcorrenciaRequestDTO dto) {

        AnaliseOcorrenciaResponseDTO analise =
                service.cadastrar(dto);

        return ResponseEntity.ok(analise);
    }

    @GetMapping
    public ResponseEntity<List<AnaliseOcorrenciaResponseDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }
}