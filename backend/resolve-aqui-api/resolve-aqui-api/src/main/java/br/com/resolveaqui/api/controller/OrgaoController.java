package br.com.resolveaqui.api.controller;

import br.com.resolveaqui.api.dto.OrgaoRequestDTO;
import br.com.resolveaqui.api.dto.OrgaoResponseDTO;
import br.com.resolveaqui.api.service.OrgaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orgaos")
public class OrgaoController {

    private final OrgaoService service;

    public OrgaoController(OrgaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrgaoResponseDTO> cadastrar(
            @Valid @RequestBody OrgaoRequestDTO dto) {

        OrgaoResponseDTO orgao = service.cadastrar(dto);

        return ResponseEntity.ok(orgao);
    }

    @GetMapping
    public ResponseEntity<List<OrgaoResponseDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }
}