package it.uniroma3.siw;

import it.uniroma3.siw.spring.model.*;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.InterventoService;
import it.uniroma3.siw.spring.service.TipoInterventoService;
import it.uniroma3.siw.spring.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SiwSpringSecurityApplication {


	public static void main(String[] args) {
		SpringApplication.run(SiwSpringSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CredentialsService credentialsService, TipoInterventoService tipoInterventoService, InterventoService interventoService){
		return args -> {
			credentialsService.saveCredentialsAdmin(new Credentials(null,"admin","admin","ADMIN", new User(null,"Filippo","Scalvedi")));
			credentialsService.saveCredentials(new Credentials(null,"mario","password","DEFAULT",new User(null,"Mario","Rossi")));
			TipoIntervento revisione = tipoInterventoService.saveTipoIntervento(new TipoIntervento(null,"Revisione","Controllo generale del veicolo",30f));
			TipoIntervento tagliando = tipoInterventoService.saveTipoIntervento(new TipoIntervento(null,"Tagliando","Verifica periodica delle componenti",40f));
			TipoIntervento turbo= tipoInterventoService.saveTipoIntervento(new TipoIntervento(null,"Installazione turbo incredibile","Inserimento nel motore di super turbo incredibile NOS ",1000f));



		};
	}

}
