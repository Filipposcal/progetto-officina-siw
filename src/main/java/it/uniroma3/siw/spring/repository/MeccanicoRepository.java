package it.uniroma3.siw.spring.repository;

import it.uniroma3.siw.spring.model.Meccanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeccanicoRepository extends JpaRepository<Meccanico,Long>{
}
