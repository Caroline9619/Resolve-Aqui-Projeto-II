package br.com.resolveaqui.api.service;

import br.com.resolveaqui.api.dto.OcorrenciaRequestDTO;
import br.com.resolveaqui.api.dto.OcorrenciaResponseDTO;
import br.com.resolveaqui.api.model.Ocorrencia;
import br.com.resolveaqui.api.model.Usuario;
import br.com.resolveaqui.api.repository.OcorrenciaRepository;
import br.com.resolveaqui.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository repository;
    private final UsuarioRepository usuarioRepository;

    public OcorrenciaService(
            OcorrenciaRepository repository,
            UsuarioRepository usuarioRepository) {

        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public OcorrenciaResponseDTO cadastrar(OcorrenciaRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        Ocorrencia ocorrencia = new Ocorrencia(
                dto.titulo(),
                dto.descricao(),
                dto.categoria(),
                dto.localizacao(),
                dto.fotoVideo(),
                dto.prioridade(),
                "registrada",
                usuario
        );

        Ocorrencia ocorrenciaSalva = repository.save(ocorrencia);

        return OcorrenciaResponseDTO.fromEntity(ocorrenciaSalva);
    }

    @Transactional(readOnly = true)
    public List<OcorrenciaResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(OcorrenciaResponseDTO::fromEntity)
                .toList();
    }
}