package it.uniroma3.siw.spring.service;

import it.uniroma3.siw.spring.model.Meccanico;
import it.uniroma3.siw.spring.repository.MeccanicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeccanicoService {

    private MeccanicoRepository meccanicoRepository;

    public Meccanico getMeccanico(Long id){
        return this.meccanicoRepository.getById(id);
    }

    public Meccanico save(Meccanico meccanico){
        return this.meccanicoRepository.save(meccanico);
    }

    public List<Meccanico> findAll(){
        return this.meccanicoRepository.findAll();
    }
}
