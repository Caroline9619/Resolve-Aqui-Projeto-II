package br.com.resolveaqui.api.service;

import br.com.resolveaqui.api.dto.ConclusaoOcorrenciaRequestDTO;
import br.com.resolveaqui.api.dto.ConclusaoOcorrenciaResponseDTO;
import br.com.resolveaqui.api.model.ConclusaoOcorrencia;
import br.com.resolveaqui.api.model.Ocorrencia;
import br.com.resolveaqui.api.repository.ConclusaoOcorrenciaRepository;
import br.com.resolveaqui.api.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConclusaoOcorrenciaService {

    private final ConclusaoOcorrenciaRepository repository;
    private final OcorrenciaRepository ocorrenciaRepository;

    public ConclusaoOcorrenciaService(
            ConclusaoOcorrenciaRepository repository,
            OcorrenciaRepository ocorrenciaRepository) {

        this.repository = repository;
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Transactional
    public ConclusaoOcorrenciaResponseDTO cadastrar(
            ConclusaoOcorrenciaRequestDTO dto) {

        Ocorrencia ocorrencia = ocorrenciaRepository
                .findById(dto.ocorrenciaId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Ocorrência não encontrada."
                ));

        ConclusaoOcorrencia conclusao = new ConclusaoOcorrencia(
                dto.resultado(),
                LocalDateTime.now(),
                ocorrencia
        );

        ConclusaoOcorrencia conclusaoSalva =
                repository.save(conclusao);

        ocorrencia.setStatus("concluída");
        ocorrenciaRepository.save(ocorrencia);

        return ConclusaoOcorrenciaResponseDTO.fromEntity(
                conclusaoSalva
        );
    }

    @Transactional(readOnly = true)
    public List<ConclusaoOcorrenciaResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(ConclusaoOcorrenciaResponseDTO::fromEntity)
                .toList();
    }
}
