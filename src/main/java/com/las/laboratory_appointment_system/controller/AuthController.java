package com.las.laboratory_appointment_system.controller;
import com.las.laboratory_appointment_system.dto.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username);
        System.out.println(password);
        if(Objects.equals(username, "abc") && Objects.equals(password, "123")){
            return "redirect:/patients";        }
        return "redirect:doctors";
    }

/*    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }*/
}
