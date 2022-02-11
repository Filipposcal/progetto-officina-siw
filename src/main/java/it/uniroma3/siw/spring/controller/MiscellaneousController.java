package it.uniroma3.siw.spring.controller;

import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MiscellaneousController {

    @Autowired
    private CredentialsService credentialsService;

    @RequestMapping("/")
    public String redirectPage() {
        return "redirect:Welcome";
    }

    @RequestMapping("/welcome")
    public String showHomePage() {
        return "index.html";
    }

    @RequestMapping("/contacts")
    public String showContactsPage() {
        return "contacts.html";
    }

    @RequestMapping("/home")

    public String redirectHome(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
        if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
            return "admin/home";
        }
        return "home";
    }


}