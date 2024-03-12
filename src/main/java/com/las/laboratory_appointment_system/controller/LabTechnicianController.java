package com.las.laboratory_appointment_system.controller;

import com.las.laboratory_appointment_system.dto.LabTechnicianDto;
import com.las.laboratory_appointment_system.model.LabTechnician;
import com.las.laboratory_appointment_system.service.LabTechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LabTechnicianController {
    private final LabTechnicianService labTechnicianService;

    @Autowired
    public LabTechnicianController(LabTechnicianService labTechnicianService) {
        this.labTechnicianService = labTechnicianService;
    }


    @GetMapping("/labTechnicians")
    public String listLabTechnicians(Model model) {
        List<LabTechnicianDto> labTechnicians = labTechnicianService.findAllLabTechnicians();
        model.addAttribute("labTechnicians", labTechnicians);
        return "labTechnician/labTechnicians-list";
    }

    @GetMapping("/labTechnicians/search")
    public String searchLabTechnicians(@RequestParam(value = "query") String query, Model model) {
        List<LabTechnicianDto> labTechnicians = labTechnicianService.searchLabTechnicians(query);
        model.addAttribute("labTechnicians", labTechnicians);
        return "labTechnician/labTechnicians-list";
    }

    @GetMapping("/labTechnicians/new")
    public String createLabTechnicianForm(Model model) {
        LabTechnician labTechnician = new LabTechnician();
        model.addAttribute("labTechnician", labTechnician);
        return "labTechnician/labTechnician-create";
    }

    @PostMapping("/labTechnicians/new")
    public String saveLabTechnician(@ModelAttribute("labTechnician") LabTechnician labTechnician) {
        labTechnicianService.saveLabTechnician(labTechnician);
        return "redirect:/labTechnicians";
    }

    @GetMapping("/labTechnicians/{user_id}/edit")
    public String editLabTechnicianForm(@PathVariable("user_id") int labTechnicianId, Model model) {
        LabTechnicianDto labTechnician = labTechnicianService.findLabTechnicianById(labTechnicianId);
        model.addAttribute("labTechnician", labTechnician);
        return "labTechnician/labTechnician-edit";
    }

    @PostMapping("/labTechnicians/{user_id}/edit")
    public String updateLabTechnician(@PathVariable("user_id") int userId, @ModelAttribute("labTechnician") LabTechnicianDto labTechnicianDto) {
        labTechnicianDto.setUser_id(userId);
        System.out.print(labTechnicianDto);
        labTechnicianService.updateLabTechnician(labTechnicianDto);
        return "redirect:/labTechnicians";
    }

    @GetMapping("/labTechnicians/{user_id}")
    public String labTechnicianDetail(@PathVariable("user_id") int labTechnicianId, Model model) {
        LabTechnicianDto labTechnicianDto = labTechnicianService.findLabTechnicianById(labTechnicianId);
        model.addAttribute("labTechnician", labTechnicianDto);
        return "labTechnician/labTechnician-detail";
    }

    @GetMapping("/labTechnicians/{user_id}/delete")
    public String deleteClub(@PathVariable("user_id") int labTechnicianId) {
        labTechnicianService.delete(labTechnicianId);
        return "redirect:/labTechnicians";
    }
}
