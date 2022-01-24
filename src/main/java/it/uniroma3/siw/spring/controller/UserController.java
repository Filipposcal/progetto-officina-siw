package it.uniroma3.siw.spring.controller;

import it.uniroma3.siw.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {

    UserService userService;

    @GetMapping (path="/admin/users/all")
    public String getUsers(Model model){
        model.addAttribute("users",this.userService.getAllUsers());
        return "users";
    }

    @GetMapping (path="/admin/user/{id}")
    public String getUser(Model model, @PathVariable Long id){
        model.addAttribute("user",this.userService.getUser(id));
        return "user";
    }

}
