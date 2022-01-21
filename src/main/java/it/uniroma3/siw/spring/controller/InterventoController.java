package it.uniroma3.siw.spring.controller;

import it.uniroma3.siw.spring.controller.validator.InterventoValidator;
import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.service.InterventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InterventoController {

    @Autowired
    private InterventoService interventoService;
    @Autowired
    private InterventoValidator interventoValidator;

    @GetMapping (path="/admin/intervento")
    public String addIntervento(Model model){
        model.addAttribute("intervento",new Intervento());
        return "interventoForm";
    }


    @PostMapping(path="/admin/intervento")
    public String addIntervento(@ModelAttribute("intervento") Intervento intervento, Model model, BindingResult bindingResult){
        this.interventoValidator.validate(intervento,bindingResult);
        if(!bindingResult.hasErrors()){
            this.interventoService.saveIntervento(intervento);
        }
        model.addAttribute("interventi",this.interventoService.findAll());
        return "interventi";
    }

    @GetMapping(path="/intervento/{id}")
    public String getIntervento(@PathVariable Long id, Model model){
        model.addAttribute("intervento",this.interventoService.getIntervento(id));
        return "intervento";
    }

    @GetMapping(path="/interventiPassati")
    public String getInterventi(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("interventi",this.interventoService.interventiByUser(this.interventoService.getCredentialsService().getUserByUsername(userDetails.getUsername())));
        return "interventi";
    }

}
