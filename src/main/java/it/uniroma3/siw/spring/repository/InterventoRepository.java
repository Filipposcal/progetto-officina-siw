package it.uniroma3.siw.spring.repository;

import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterventoRepository extends JpaRepository<Intervento,Long> {
    List<Intervento> findByUser(User user);
}
