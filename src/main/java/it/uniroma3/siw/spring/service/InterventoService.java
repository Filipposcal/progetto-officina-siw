package it.uniroma3.siw.spring.service;

import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.repository.InterventoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Getter
@Setter
public class InterventoService {

    @Autowired
    private InterventoRepository interventoRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CredentialsService credentialsService;

    public Intervento getIntervento(Long id) {
        return this.interventoRepository.getById(id);
    }


    public List<Intervento> interventiByUser(User user) {
        List<Intervento> interventi = interventoRepository.findAll();
        List<Intervento> result = interventi.stream().filter(p -> p.getUser() == user)
                .collect(Collectors.toList());
        return result;
    }

    public Intervento saveIntervento(Intervento intervento) {
        return this.interventoRepository.save(intervento);
    }

    public List<Intervento> findAll() {
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
