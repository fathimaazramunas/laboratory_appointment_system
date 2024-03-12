package com.las.laboratory_appointment_system.service;

import com.las.laboratory_appointment_system.dto.DoctorDto;
import com.las.laboratory_appointment_system.dto.UserDropListDto;
import com.las.laboratory_appointment_system.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> findAllDoctors();

    Doctor saveDoctor(Doctor doctor);

    DoctorDto findDoctorById(int doctorId);

    void updateDoctor(DoctorDto doctor);

    void delete(int doctorId);

    List<DoctorDto> searchDoctors(String query);


    List<UserDropListDto> getDropList();
}
