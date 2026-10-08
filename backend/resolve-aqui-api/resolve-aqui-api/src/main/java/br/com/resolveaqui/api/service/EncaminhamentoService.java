package br.com.resolveaqui.api.service;

import br.com.resolveaqui.api.dto.EncaminhamentoRequestDTO;
import br.com.resolveaqui.api.dto.EncaminhamentoResponseDTO;
import br.com.resolveaqui.api.model.Encaminhamento;
import br.com.resolveaqui.api.model.Ocorrencia;
import br.com.resolveaqui.api.model.Orgao;
import br.com.resolveaqui.api.repository.EncaminhamentoRepository;
import br.com.resolveaqui.api.repository.OcorrenciaRepository;
import br.com.resolveaqui.api.repository.OrgaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EncaminhamentoService {

    private final EncaminhamentoRepository repository;
    private final OcorrenciaRepository ocorrenciaRepository;
    private final OrgaoRepository orgaoRepository;

    public EncaminhamentoService(
            EncaminhamentoRepository repository,
            OcorrenciaRepository ocorrenciaRepository,
            OrgaoRepository orgaoRepository) {

        this.repository = repository;
        this.ocorrenciaRepository = ocorrenciaRepository;
        this.orgaoRepository = orgaoRepository;
    }

    @Transactional
    public EncaminhamentoResponseDTO cadastrar(
            EncaminhamentoRequestDTO dto) {

        Ocorrencia ocorrencia = ocorrenciaRepository
                .findById(dto.ocorrenciaId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Ocorrência não encontrada."
                ));

        Orgao orgao = orgaoRepository
                .findById(dto.orgaoId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Órgão não encontrado."
                ));

        Encaminhamento encaminhamento = new Encaminhamento(
                dto.observacao(),
                LocalDateTime.now(),
                ocorrencia,
                orgao
        );

        Encaminhamento encaminhamentoSalvo =
                repository.save(encaminhamento);

        ocorrencia.setStatus("encaminhada");
        ocorrenciaRepository.save(ocorrencia);

        return EncaminhamentoResponseDTO.fromEntity(
                encaminhamentoSalvo
        );
    }

    @Transactional(readOnly = true)
    public List<EncaminhamentoResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(EncaminhamentoResponseDTO::fromEntity)
                .toList();
    }
}