package com.las.laboratory_appointment_system.controller;

import com.las.laboratory_appointment_system.dto.RegistrationDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthController {

    @GetMapping("/")
    public String home() {
        return "patient/patients-list";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }
}
