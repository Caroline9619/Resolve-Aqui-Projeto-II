package br.com.resolveaqui.api.repository;

import br.com.resolveaqui.api.model.ConclusaoOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConclusaoOcorrenciaRepository
        extends JpaRepository<ConclusaoOcorrencia, Long> {
}