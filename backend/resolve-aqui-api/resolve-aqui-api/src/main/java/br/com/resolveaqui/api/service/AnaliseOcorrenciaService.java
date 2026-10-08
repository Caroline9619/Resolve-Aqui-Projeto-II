package br.com.resolveaqui.api.service;

import br.com.resolveaqui.api.dto.AnaliseOcorrenciaRequestDTO;
import br.com.resolveaqui.api.dto.AnaliseOcorrenciaResponseDTO;
import br.com.resolveaqui.api.model.AnaliseOcorrencia;
import br.com.resolveaqui.api.model.Ocorrencia;
import br.com.resolveaqui.api.repository.AnaliseOcorrenciaRepository;
import br.com.resolveaqui.api.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnaliseOcorrenciaService {

    private final AnaliseOcorrenciaRepository repository;
    private final OcorrenciaRepository ocorrenciaRepository;

    public AnaliseOcorrenciaService(
            AnaliseOcorrenciaRepository repository,
            OcorrenciaRepository ocorrenciaRepository) {

        this.repository = repository;
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Transactional
    public AnaliseOcorrenciaResponseDTO cadastrar(
            AnaliseOcorrenciaRequestDTO dto) {

        Ocorrencia ocorrencia = ocorrenciaRepository
                .findById(dto.ocorrenciaId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Ocorrência não encontrada."
                ));

        AnaliseOcorrencia analise = new AnaliseOcorrencia(
                dto.resultado(),
                dto.observacao(),
                LocalDateTime.now(),
                ocorrencia
        );

        AnaliseOcorrencia analiseSalva = repository.save(analise);

        ocorrencia.setStatus("em análise");
        ocorrenciaRepository.save(ocorrencia);

        return AnaliseOcorrenciaResponseDTO.fromEntity(analiseSalva);
    }

    @Transactional(readOnly = true)
    public List<AnaliseOcorrenciaResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(AnaliseOcorrenciaResponseDTO::fromEntity)
                .toList();
    }
}