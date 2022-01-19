package it.uniroma3.siw.spring.service;

import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.model.TipoIntervento;
import it.uniroma3.siw.spring.repository.TipoInterventoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service @Transactional
public class TipoInterventoService {

    private TipoInterventoRepository tipoInterventoRepository;

    public TipoIntervento getTipoIntervento(Long id){
        return this.tipoInterventoRepository.getById(id);
    }

    public TipoIntervento saveTipoIntervento(TipoIntervento tipoIntervento){
        return this.tipoInterventoRepository.save(tipoIntervento);
    }

    public List<TipoIntervento> findAll(){
        return this.tipoInterventoRepository.findAll();
    }

    public boolean alreadyExists(TipoIntervento tipoIntervento) {
        List<TipoIntervento> tipiIntervento = new ArrayList<>();
        tipiIntervento.add(this.tipoInterventoRepository.findById(tipoIntervento.getId()).orElse(null));
        if (tipiIntervento.size() > 0)
            return true;
        else
            return false;
    }
}
