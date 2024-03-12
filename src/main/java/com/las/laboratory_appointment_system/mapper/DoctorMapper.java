package com.las.laboratory_appointment_system.mapper;

import com.las.laboratory_appointment_system.dto.DoctorDto;
import com.las.laboratory_appointment_system.model.Doctor;

public class DoctorMapper {
    public static DoctorDto doctorToDoctorDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setUser_id(doctor.getUser_id());
        doctorDto.setUsername(doctor.getUsername());
        doctorDto.setRole(doctor.getRole());
        doctorDto.setFirst_name(doctor.getFirst_name());
        doctorDto.setLast_name(doctor.getLast_name());
        doctorDto.setDate_of_birth(doctor.getDate_of_birth());
        doctorDto.setAddress(doctor.getAddress());
        doctorDto.setPhone_number(doctor.getPhone_number());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setDepartment(doctor.getDepartment());
        doctorDto.setSpecialize(doctor.getSpecialize());
        return doctorDto;
    }

    public static Doctor doctorDtoToDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setUser_id(doctorDto.getUser_id());
        doctor.setUsername(doctorDto.getUsername());
        doctor.setRole(doctorDto.getRole());
        doctor.setFirst_name(doctorDto.getFirst_name());
        doctor.setLast_name(doctorDto.getLast_name());
        doctor.setDate_of_birth(doctorDto.getDate_of_birth());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setPhone_number(doctorDto.getPhone_number());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setDepartment(doctorDto.getDepartment());
        doctor.setSpecialize(doctorDto.getSpecialize());
        return doctor;
    }
}
