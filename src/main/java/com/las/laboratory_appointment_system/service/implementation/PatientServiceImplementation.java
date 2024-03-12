package com.las.laboratory_appointment_system.service.implementation;

import com.las.laboratory_appointment_system.dto.PatientDto;
import com.las.laboratory_appointment_system.dto.UserDropListDto;
import com.las.laboratory_appointment_system.mapper.PatientMapper;
import com.las.laboratory_appointment_system.model.Patient;
import com.las.laboratory_appointment_system.repository.PatientRepository;
import com.las.laboratory_appointment_system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.las.laboratory_appointment_system.mapper.AppointmentMapper.mapObjToAppointmentListViewDto;
import static com.las.laboratory_appointment_system.mapper.UserDropListMapper.mapObjToUserDropListDto;

@Service
public class PatientServiceImplementation implements PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImplementation(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDto> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::patientToPatientDto).collect(Collectors.toList());
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public PatientDto findPatientById(int patientId) {
        Patient patient = patientRepository.findById(patientId).get();
        return PatientMapper.patientToPatientDto(patient);
    }

    public void updatePatient(PatientDto patientDto) {
        Patient patient = PatientMapper.patientDtoToPatient(patientDto);
        patientRepository.save(patient);
    }

    public void delete(int patientId) {
        patientRepository.deleteById(patientId);
    }

    public List<PatientDto> searchPatients(String query) {
        List<Patient> patients = patientRepository.searchPatients(query);
        return patients.stream().map(PatientMapper::patientToPatientDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDropListDto> getDropList() {
        List<Object[]> userDropListObj = patientRepository.getUserDropList();
        return mapObjToUserDropListDto(userDropListObj);
    }


}
