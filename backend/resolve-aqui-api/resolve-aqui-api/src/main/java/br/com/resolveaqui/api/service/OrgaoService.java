package br.com.resolveaqui.api.service;

import br.com.resolveaqui.api.dto.OrgaoRequestDTO;
import br.com.resolveaqui.api.dto.OrgaoResponseDTO;
import br.com.resolveaqui.api.model.Orgao;
import br.com.resolveaqui.api.repository.OrgaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrgaoService {

    private final OrgaoRepository repository;

    public OrgaoService(OrgaoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OrgaoResponseDTO cadastrar(OrgaoRequestDTO dto) {

        Orgao orgao = new Orgao(
                dto.nome(),
                dto.secretaria(),
                dto.descricao()
        );

        Orgao orgaoSalvo = repository.save(orgao);

        return OrgaoResponseDTO.fromEntity(orgaoSalvo);
    }

    @Transactional(readOnly = true)
    public List<OrgaoResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(OrgaoResponseDTO::fromEntity)
                .toList();
    }
}