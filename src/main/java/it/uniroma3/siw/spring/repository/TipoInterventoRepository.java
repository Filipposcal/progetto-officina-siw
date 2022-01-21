package it.uniroma3.siw.spring.repository;

import it.uniroma3.siw.spring.model.TipoIntervento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoInterventoRepository extends JpaRepository<TipoIntervento, Long> {
}
