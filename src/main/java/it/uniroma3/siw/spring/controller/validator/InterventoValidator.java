package it.uniroma3.siw.spring.controller.validator;

import it.uniroma3.siw.spring.model.Intervento;

import it.uniroma3.siw.spring.model.Prodotto;
import it.uniroma3.siw.spring.service.InterventoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class InterventoValidator implements Validator {

    @Autowired
    private InterventoService interventoService;

    private static final Logger logger = LoggerFactory.getLogger(InterventoValidator.class);

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "meccanico", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipoIntervento", "required");

        if (!errors.hasErrors()) {
            logger.debug("confermato: valori non nulli");
            if (this.interventoService.alreadyExists((Intervento)o)) {
                logger.debug("e' un duplicato");
                errors.reject("duplicato");
            }
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Prodotto.class.equals(aClass);
    }
}
