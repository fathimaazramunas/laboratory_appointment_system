package com.las.laboratory_appointment_system.controller;

import com.las.laboratory_appointment_system.dto.DoctorDto;
import com.las.laboratory_appointment_system.model.Doctor;
import com.las.laboratory_appointment_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping("/doctors")
    public String listDoctors(Model model) {
        List<DoctorDto> doctors = doctorService.findAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctor/doctors-list";
    }

    @GetMapping("/doctors/search")
    public String searchDoctors(@RequestParam(value = "query") String query, Model model) {
        List<DoctorDto> doctors = doctorService.searchDoctors(query);
        model.addAttribute("doctors", doctors);
        return "doctor/doctors-list";
    }

    @GetMapping("/doctors/new")
    public String createDoctorForm(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "doctor/doctor-create";
    }

    @PostMapping("/doctors/new")
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/{user_id}/edit")
    public String editDoctorForm(@PathVariable("user_id") int doctorId, Model model) {
        DoctorDto doctor = doctorService.findDoctorById(doctorId);
        model.addAttribute("doctor", doctor);
        return "doctor/doctor-edit";
    }

    @PostMapping("/doctors/{user_id}/edit")
    public String updateDoctor(@PathVariable("user_id") int userId, @ModelAttribute("doctor") DoctorDto doctorDto) {
        doctorDto.setUser_id(userId);
        System.out.print(doctorDto);
        doctorService.updateDoctor(doctorDto);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/{user_id}")
    public String doctorDetail(@PathVariable("user_id") int doctorId, Model model) {
        DoctorDto doctorDto = doctorService.findDoctorById(doctorId);
        model.addAttribute("doctor", doctorDto);
        return "doctor/doctor-detail";
    }

    @GetMapping("/doctors/{user_id}/delete")
    public String deleteDoctor(@PathVariable("user_id") int doctorId) {
        doctorService.delete(doctorId);
        return "redirect:/doctors";
    }
}
