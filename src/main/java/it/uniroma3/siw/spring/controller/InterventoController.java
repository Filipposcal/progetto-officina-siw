package it.uniroma3.siw.spring.controller;

import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.service.InterventoService;
import it.uniroma3.siw.spring.service.TipoInterventoService;
import it.uniroma3.siw.spring.service.UserService;
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
    private TipoInterventoService tipoInterventoService;
    @Autowired
    private UserService userService;

    

    @GetMapping (path="/admin/intervento")
    public String addIntervento(Model model){
        model.addAttribute("tipiIntervento",tipoInterventoService.findAll());
        model.addAttribute("users",this.userService.getAllUsers());
        model.addAttribute("intervento",new Intervento());
        return "/admin/newIntervento";
    }


    @PostMapping(path="/admin/intervento/save")
    public String addIntervento(@ModelAttribute("intervento") Intervento intervento, Model model, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            this.interventoService.saveIntervento(intervento);
        }
        model.addAttribute("interventi",this.interventoService.findAll());
        return "admin/interventoSuccessful";
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
        model.addAttribute("tipiIntervento",this.tipoInterventoService.findAll());

        return "interventiPassati";
    }

}
