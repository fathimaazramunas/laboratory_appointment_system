package com.las.laboratory_appointment_system.service;

import com.las.laboratory_appointment_system.dto.LabTechnicianDto;
import com.las.laboratory_appointment_system.model.LabTechnician;

import java.util.List;

public interface LabTechnicianService {
    List<LabTechnicianDto> findAllLabTechnicians();

    LabTechnician saveLabTechnician(LabTechnician labTechnician);

    LabTechnicianDto findLabTechnicianById(int labTechnicianId);

    void updateLabTechnician(LabTechnicianDto labTechnician);

    void delete(int labTechnicianId);

    List<LabTechnicianDto> searchLabTechnicians(String query);
}
