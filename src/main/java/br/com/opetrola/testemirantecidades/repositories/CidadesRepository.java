package br.com.opetrola.testemirantecidades.repositories;

import br.com.opetrola.testemirantecidades.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadesRepository extends JpaRepository<Cidade, Long> {
}
