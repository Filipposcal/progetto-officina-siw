package it.uniroma3.siw.spring.service;

import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.repository.InterventoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service @Transactional
public class InterventoService {

    private InterventoRepository interventoRepository;

    public Intervento getIntervento(Long id){
        return this.interventoRepository.getById(id);
    }

    public Intervento saveIntervento(Intervento intervento){
        return this.interventoRepository.save(intervento);
    }

    public List<Intervento> findAll(){
        return this.interventoRepository.findAll();
    }

    public boolean alreadyExists(Intervento intervento) {
        List<Intervento> interventi = new ArrayList<>();
        interventi.add(this.interventoRepository.findById(intervento.getId()).orElse(null));
        if (interventi.size() > 0)
            return true;
        else
            return false;
    }


}
