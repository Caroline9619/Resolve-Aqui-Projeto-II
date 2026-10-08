package br.com.resolveaqui.api.repository;

import br.com.resolveaqui.api.model.AnaliseOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseOcorrenciaRepository
        extends JpaRepository<AnaliseOcorrencia, Long> {
}