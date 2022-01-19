package it.uniroma3.siw.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Meccanico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cognome;
    @OneToMany
    private List<TipoIntervento> interventiDisponibili = new ArrayList<>();
}
