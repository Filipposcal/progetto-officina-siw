package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomePageController {

    @RequestMapping("/")
    public String redirectPage() {
        return "redirect:Welcome";
    }


    @RequestMapping("/welcome")
    public String showHomePage() {
        return "index.html";
    }
}