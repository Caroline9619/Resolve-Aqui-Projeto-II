
package br.com.resolveaqui.api.repository;

import br.com.resolveaqui.api.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

    List<Ocorrencia> findByUsuarioId(Long usuarioId);

}
