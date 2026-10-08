package br.com.resolveaqui.api.dto;

import br.com.resolveaqui.api.model.Orgao;

public record OrgaoResponseDTO(
        Long id,
        String nome,
        String secretaria,
        String descricao
) {

    public static OrgaoResponseDTO fromEntity(Orgao orgao) {

        return new OrgaoResponseDTO(
                orgao.getId(),
                orgao.getNome(),
                orgao.getSecretaria(),
                orgao.getDescricao()
        );
    }
}