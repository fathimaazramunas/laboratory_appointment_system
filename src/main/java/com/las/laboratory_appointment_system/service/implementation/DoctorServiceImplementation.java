package com.las.laboratory_appointment_system.service.implementation;

import com.las.laboratory_appointment_system.dto.DoctorDto;
import com.las.laboratory_appointment_system.dto.UserDropListDto;
import com.las.laboratory_appointment_system.mapper.DoctorMapper;
import com.las.laboratory_appointment_system.model.Doctor;
import com.las.laboratory_appointment_system.repository.DoctorRepository;
import com.las.laboratory_appointment_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.las.laboratory_appointment_system.mapper.UserDropListMapper.mapObjToUserDropListDto;

@Service
public class DoctorServiceImplementation implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImplementation(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorDto> findAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(DoctorMapper::doctorToDoctorDto).collect(Collectors.toList());
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public DoctorDto findDoctorById(int doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
        return DoctorMapper.doctorToDoctorDto(doctor);
    }

    public void updateDoctor(DoctorDto doctorDto) {
        Doctor doctor = DoctorMapper.doctorDtoToDoctor(doctorDto);
        doctorRepository.save(doctor);
    }

    public void delete(int doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    public List<DoctorDto> searchDoctors(String query) {
        List<Doctor> doctors = doctorRepository.searchDoctors(query);
        return doctors.stream().map(DoctorMapper::doctorToDoctorDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDropListDto> getDropList() {
        List<Object[]> userDropListObj = doctorRepository.getUserDropList();
        return mapObjToUserDropListDto(userDropListObj);
    }

}
