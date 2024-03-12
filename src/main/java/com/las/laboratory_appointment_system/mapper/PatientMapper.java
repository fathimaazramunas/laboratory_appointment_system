package com.las.laboratory_appointment_system.mapper;

import com.las.laboratory_appointment_system.dto.PatientDto;
import com.las.laboratory_appointment_system.model.Patient;
public class PatientMapper {
    public static PatientDto patientToPatientDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setUser_id(patient.getUser_id());
        patientDto.setUsername(patient.getUsername());
        patientDto.setRole(patient.getRole());
        patientDto.setFirst_name(patient.getFirst_name());
        patientDto.setLast_name(patient.getLast_name());
        patientDto.setDate_of_birth(patient.getDate_of_birth());
        patientDto.setAddress(patient.getAddress());
        patientDto.setPhone_number(patient.getPhone_number());
        patientDto.setEmail(patient.getEmail());
        patientDto.setInsurance_provider(patient.getInsurance_provider());
        patientDto.setBlood_type(patient.getBlood_type());
        return patientDto;
    }

    public static Patient patientDtoToPatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setUser_id(patientDto.getUser_id());
        patient.setUsername(patientDto.getUsername());
        patient.setRole(patientDto.getRole());
        patient.setFirst_name(patientDto.getFirst_name());
        patient.setLast_name(patientDto.getLast_name());
        patient.setDate_of_birth(patientDto.getDate_of_birth());
        patient.setAddress(patientDto.getAddress());
        patient.setPhone_number(patientDto.getPhone_number());
        patient.setEmail(patientDto.getEmail());
        patient.setInsurance_provider(patientDto.getInsurance_provider());
        patient.setBlood_type(patientDto.getBlood_type());
        return patient;
    }
}
