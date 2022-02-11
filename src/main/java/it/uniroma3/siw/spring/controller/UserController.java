package it.uniroma3.siw.spring.controller;

import it.uniroma3.siw.spring.controller.validator.UserValidator;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/admin/users/all")
    public String getUsers(Model model) {
        model.addAttribute("users", this.userService.getAllUsers());
        return "admin/allUsers";
    }

    @RequestMapping(value = "/admin/user/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/newUser.html";
    }


    @RequestMapping(value = {"/admin/user/register"}, method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user,
                               BindingResult userBindingResult) {
        userService.saveUser(user);
        return "admin/userSuccessful";
    }

    @PostMapping(path = "/admin/user/save")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "admin/userSuccessful";
    }

    @RequestMapping(value = {"/admin/user/update"}, method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user,
                               BindingResult userBindingResult) {
        user.setNome(user.getNome());
        user.setCognome((user.getCognome()));
        return "admin/userSuccessful";
    }


    @GetMapping(path = "/admin/user/{id}")
    public String getUser(Model model, @PathVariable Long id) {
        model.addAttribute("user", this.userService.getUser(id));
        return "user";
    }

    @GetMapping (path = "/admin/user/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value="id")Long id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "admin/updateForm";
    }


}
