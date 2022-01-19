package it.uniroma3.siw.spring.controller;

import it.uniroma3.siw.spring.controller.validator.TipoInterventoValidator;
import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.model.TipoIntervento;
import it.uniroma3.siw.spring.service.TipoInterventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TipoInterventoController {

    @Autowired
    TipoInterventoService tipoInterventoService;
    @Autowired
    TipoInterventoValidator tipoInterventoValidator;

    @GetMapping(path="/admin/tipointervento")
    public String addTipoIntervento(Model model){
        model.addAttribute("tipoIntervento",new TipoIntervento());
        return "tipoInterventoForm";
    }

    @PostMapping(path="/admin/tipointervento")
    public String addTipoIntervento(@ModelAttribute("tipoIntervento") TipoIntervento tipoIntervento, Model model, BindingResult bindingResult){
        this.tipoInterventoValidator.validate(tipoIntervento,bindingResult);
        if(!bindingResult.hasErrors())
            this.tipoInterventoService.saveTipoIntervento(tipoIntervento);
        model.addAttribute("tipiIntervento",this.tipoInterventoService.findAll());
        return "tipiIntervento";
    }

    @GetMapping(path="/tipointervento/{id}")
    public String getTipoIntervento(@PathVariable Long id, Model model){
        model.addAttribute("tipoIntervento",this.tipoInterventoService.getTipoIntervento(id));
        return "tipoIntervento";
    }

    @GetMapping(path="/tipoIntervento/all")
    public String getTipiIntervento(Model model){
        model.addAttribute("tipiIntervento",this.tipoInterventoService.findAll());
        return "tipiIntervento";
    }
}

