package br.com.resolveaqui.api.controller;

import br.com.resolveaqui.api.dto.OcorrenciaRequestDTO;
import br.com.resolveaqui.api.dto.OcorrenciaResponseDTO;
import br.com.resolveaqui.api.service.OcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OcorrenciaResponseDTO> cadastrar(
            @Valid @RequestBody OcorrenciaRequestDTO dto) {

        OcorrenciaResponseDTO ocorrencia = service.cadastrar(dto);

        return ResponseEntity.ok(ocorrencia);
    }

    @GetMapping
    public ResponseEntity<List<OcorrenciaResponseDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }
}
