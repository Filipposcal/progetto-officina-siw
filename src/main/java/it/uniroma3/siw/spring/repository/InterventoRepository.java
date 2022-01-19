package it.uniroma3.siw.spring.repository;

import it.uniroma3.siw.spring.model.Intervento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventoRepository extends JpaRepository<Intervento,Long> {
}
