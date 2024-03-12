package com.las.laboratory_appointment_system.controller;

import com.las.laboratory_appointment_system.dto.PatientDto;
import com.las.laboratory_appointment_system.model.Patient;
import com.las.laboratory_appointment_system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("/patients")
    public String listPatients(Model model) {
        List<PatientDto> patients = patientService.findAllPatients();
        model.addAttribute("patients", patients);
        return "patient/patients-list";
    }

    @GetMapping("/patients/search")
    public String searchPatients(@RequestParam(value = "query") String query, Model model) {
        List<PatientDto> patients = patientService.searchPatients(query);
        model.addAttribute("patients", patients);
        return "patient/patients-list";
    }

    @GetMapping("/patients/new")
    public String createPatientForm(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "patient/patient-create";
    }

    @PostMapping("/patients/new")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/{user_id}/edit")
    public String editPatientForm(@PathVariable("user_id") int patientId, Model model) {
        PatientDto patient = patientService.findPatientById(patientId);
        model.addAttribute("patient", patient);
        return "patient/patient-edit";
    }

    @PostMapping("/patients/{user_id}/edit")
    public String updatePatient(@PathVariable("user_id") int userId, @ModelAttribute("patient") PatientDto patientDto) {
        patientDto.setUser_id(userId);
        System.out.print(patientDto);
        patientService.updatePatient(patientDto);
        return "redirect:/patients";
    }

    @GetMapping("/patients/{user_id}")
    public String patientDetail(@PathVariable("user_id") int patientId, Model model) {
        PatientDto patientDto = patientService.findPatientById(patientId);
        model.addAttribute("patient", patientDto);
        return "patient/patient-detail";
    }

    @GetMapping("/patients/{user_id}/delete")
    public String deleteClub(@PathVariable("user_id") int patientId) {
        patientService.delete(patientId);
        return "redirect:/patients";
    }
}
