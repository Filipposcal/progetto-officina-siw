package it.uniroma3.siw.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Intervento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private TipoIntervento tipoIntervento;
    private LocalDate dataPrenotazione;
    private LocalDateTime appuntamento;
    @OneToOne
    private Meccanico meccanico;
}
