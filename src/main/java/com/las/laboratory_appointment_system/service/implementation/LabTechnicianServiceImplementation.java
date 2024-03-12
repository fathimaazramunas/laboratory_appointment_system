package com.las.laboratory_appointment_system.service.implementation;

import com.las.laboratory_appointment_system.dto.LabTechnicianDto;
import com.las.laboratory_appointment_system.mapper.LabTechnicianMapper;
import com.las.laboratory_appointment_system.model.LabTechnician;
import com.las.laboratory_appointment_system.repository.LabTechnicianRepository;
import com.las.laboratory_appointment_system.service.LabTechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabTechnicianServiceImplementation implements LabTechnicianService {
    private final LabTechnicianRepository labTechnicianRepository;

    @Autowired
    public LabTechnicianServiceImplementation(LabTechnicianRepository labTechnicianRepository) {
        this.labTechnicianRepository = labTechnicianRepository;
    }

    @Override
    public List<LabTechnicianDto> findAllLabTechnicians() {
        List<LabTechnician> labTechnicians = labTechnicianRepository.findAll();
        return labTechnicians.stream().map(LabTechnicianMapper::labTechnicianToLabTechnicianDto).collect(Collectors.toList());
    }

    @Override
    public LabTechnician saveLabTechnician(LabTechnician labTechnician) {
        return labTechnicianRepository.save(labTechnician);
    }

    public LabTechnicianDto findLabTechnicianById(int labTechnicianId) {
        LabTechnician labTechnician = labTechnicianRepository.findById(labTechnicianId).get();
        return LabTechnicianMapper.labTechnicianToLabTechnicianDto(labTechnician);
    }

    public void updateLabTechnician(LabTechnicianDto labTechnicianDto) {
        LabTechnician labTechnician = LabTechnicianMapper.labTechnicianDtoToLabTechnician(labTechnicianDto);
        labTechnicianRepository.save(labTechnician);
    }

    public void delete(int labTechnicianId) {
        labTechnicianRepository.deleteById(labTechnicianId);
    }

    public List<LabTechnicianDto> searchLabTechnicians(String query) {
        List<LabTechnician> labTechnicians = labTechnicianRepository.searchLabTechnicians(query);
        return labTechnicians.stream().map(LabTechnicianMapper::labTechnicianToLabTechnicianDto).collect(Collectors.toList());
    }


}
