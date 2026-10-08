package br.com.resolveaqui.api.service;

import br.com.resolveaqui.api.dto.OcorrenciaRequestDTO;
import br.com.resolveaqui.api.dto.OcorrenciaResponseDTO;
import br.com.resolveaqui.api.enums.Prioridade;
import br.com.resolveaqui.api.model.Ocorrencia;
import br.com.resolveaqui.api.model.Orgao;
import br.com.resolveaqui.api.model.Usuario;
import br.com.resolveaqui.api.repository.OcorrenciaRepository;
import br.com.resolveaqui.api.repository.OrgaoRepository;
import br.com.resolveaqui.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final OrgaoRepository orgaoRepository;

    public OcorrenciaService(
            OcorrenciaRepository repository,
            UsuarioRepository usuarioRepository,
            OrgaoRepository orgaoRepository) {

        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.orgaoRepository = orgaoRepository;
    }

    @Transactional
    public OcorrenciaResponseDTO cadastrar(OcorrenciaRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Usuário não encontrado."
                ));

        Orgao orgao = null;

        if (dto.orgaoId() != null) {
            orgao = orgaoRepository.findById(dto.orgaoId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Órgão não encontrado."
                    ));
        }

        Prioridade prioridade = Prioridade.valueOf(
                dto.prioridade().toUpperCase()
        );

        Ocorrencia ocorrencia = new Ocorrencia(
                dto.titulo(),
                dto.descricao(),
                dto.categoria(),
                dto.localizacao(),
                dto.fotoVideo(),
                prioridade,
                "registrada",
                usuario,
                orgao
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