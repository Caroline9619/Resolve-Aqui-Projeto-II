package br.com.resolveaqui.api.service;

import br.com.resolveaqui.api.dto.AtendimentoRequestDTO;
import br.com.resolveaqui.api.dto.AtendimentoResponseDTO;
import br.com.resolveaqui.api.model.Atendimento;
import br.com.resolveaqui.api.model.Ocorrencia;
import br.com.resolveaqui.api.repository.AtendimentoRepository;
import br.com.resolveaqui.api.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtendimentoService {

    private final AtendimentoRepository repository;
    private final OcorrenciaRepository ocorrenciaRepository;

    public AtendimentoService(
            AtendimentoRepository repository,
            OcorrenciaRepository ocorrenciaRepository) {

        this.repository = repository;
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Transactional
    public AtendimentoResponseDTO cadastrar(
            AtendimentoRequestDTO dto) {

        Ocorrencia ocorrencia = ocorrenciaRepository
                .findById(dto.ocorrenciaId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Ocorrência não encontrada."
                ));

        Atendimento atendimento = new Atendimento(
                dto.descricao(),
                LocalDateTime.now(),
                ocorrencia
        );

        Atendimento atendimentoSalvo = repository.save(atendimento);

        ocorrencia.setStatus("em atendimento");
        ocorrenciaRepository.save(ocorrencia);

        return AtendimentoResponseDTO.fromEntity(atendimentoSalvo);
    }

    @Transactional(readOnly = true)
    public List<AtendimentoResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(AtendimentoResponseDTO::fromEntity)
                .toList();
    }
}