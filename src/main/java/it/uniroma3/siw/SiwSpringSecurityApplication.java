package it.uniroma3.siw;

import it.uniroma3.siw.spring.model.*;
import it.uniroma3.siw.spring.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SiwSpringSecurityApplication {


	public static void main(String[] args) {
		SpringApplication.run(SiwSpringSecurityApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(CredentialsService credentialsService, TipoInterventoService tipoInterventoService, InterventoService interventoService, UserService userService, MeccanicoService meccanicoService){
//		return args -> {
//			User filippo = new User(null,"Filippo","Scalvedi");
//			User mario = new User(null, "Mario", "Rossi");
//			credentialsService.saveCredentialsAdmin(new Credentials(null,"admin","admin","ADMIN", filippo));
//			credentialsService.saveCredentials(new Credentials(null,"mario","password","DEFAULT", mario));
//			TipoIntervento revisione = tipoInterventoService.saveTipoIntervento(new TipoIntervento(null,"Revisione","Controllo generale del veicolo",30f));
//			TipoIntervento tagliando = tipoInterventoService.saveTipoIntervento(new TipoIntervento(null,"Tagliando","Verifica periodica delle componenti",40f));
//			TipoIntervento turbo= tipoInterventoService.saveTipoIntervento(new TipoIntervento(null,"Installazione turbo incredibile","Inserimento nel motore di super turbo incredibile NOS ",1000f));
//			List<TipoIntervento> tipiDisponibili = new ArrayList<>();
//			tipiDisponibili.add(turbo);
//			List<TipoIntervento> tipiDisponibili2 = new ArrayList<>();
//			tipiDisponibili2.add(revisione);
//			tipiDisponibili2.add(tagliando);
//			Meccanico gianni = meccanicoService.save(new Meccanico(null, "Gianni", "Bianchi",tipiDisponibili));
//			Meccanico giuseppe = meccanicoService.save(new Meccanico(null, "Giuseppe", "Verdi",tipiDisponibili2));
//			interventoService.saveIntervento(new Intervento(null,filippo,revisione, LocalDate.of(2021,12,28),LocalDate.of(2022,01,10),gianni));
//			interventoService.saveIntervento(new Intervento(null,mario,tagliando, LocalDate.of(2021,12,28),LocalDate.of(2022,01,12),giuseppe));
//			interventoService.saveIntervento(new Intervento(null,mario,turbo, LocalDate.of(2021,12,28),LocalDate.of(2022,01,13),giuseppe));
//
//
//		};
//	}

}
