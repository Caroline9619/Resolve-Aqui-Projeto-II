package br.com.resolveaqui.api.repository;

import br.com.resolveaqui.api.model.Encaminhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncaminhamentoRepository
        extends JpaRepository<Encaminhamento, Long> {
}