package it.uniroma3.siw.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPrenotazione;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAppuntamento;
    @OneToOne
    private Meccanico meccanico;
}
