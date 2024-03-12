package com.las.laboratory_appointment_system.mapper;

import com.las.laboratory_appointment_system.dto.LabTechnicianDto;
import com.las.laboratory_appointment_system.model.LabTechnician;

public class LabTechnicianMapper {
    public static LabTechnicianDto labTechnicianToLabTechnicianDto(LabTechnician labTechnician) {
        LabTechnicianDto labTechnicianDto = new LabTechnicianDto();
        labTechnicianDto.setUser_id(labTechnician.getUser_id());
        labTechnicianDto.setUsername(labTechnician.getUsername());
        labTechnicianDto.setRole(labTechnician.getRole());
        labTechnicianDto.setFirst_name(labTechnician.getFirst_name());
        labTechnicianDto.setLast_name(labTechnician.getLast_name());
        labTechnicianDto.setDate_of_birth(labTechnician.getDate_of_birth());
        labTechnicianDto.setAddress(labTechnician.getAddress());
        labTechnicianDto.setPhone_number(labTechnician.getPhone_number());
        labTechnicianDto.setEmail(labTechnician.getEmail());
        labTechnicianDto.setJob_title(labTechnician.getJob_title());
        labTechnicianDto.setDepartment(labTechnician.getDepartment());
        return labTechnicianDto;
    }

    public static LabTechnician labTechnicianDtoToLabTechnician(LabTechnicianDto labTechnicianDto) {
        LabTechnician labTechnician = new LabTechnician();
        labTechnician.setUser_id(labTechnicianDto.getUser_id());
        labTechnician.setUsername(labTechnicianDto.getUsername());
        labTechnician.setRole(labTechnicianDto.getRole());
        labTechnician.setFirst_name(labTechnicianDto.getFirst_name());
        labTechnician.setLast_name(labTechnicianDto.getLast_name());
        labTechnician.setDate_of_birth(labTechnicianDto.getDate_of_birth());
        labTechnician.setAddress(labTechnicianDto.getAddress());
        labTechnician.setPhone_number(labTechnicianDto.getPhone_number());
        labTechnician.setEmail(labTechnicianDto.getEmail());
        labTechnician.setJob_title(labTechnicianDto.getJob_title());
        labTechnician.setDepartment(labTechnicianDto.getDepartment());
        return labTechnician;
    }
}
