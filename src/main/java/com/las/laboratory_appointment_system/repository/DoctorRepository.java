package com.las.laboratory_appointment_system.repository;

import com.las.laboratory_appointment_system.dto.UserDropListDto;
import com.las.laboratory_appointment_system.model.Doctor;
import com.las.laboratory_appointment_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    @Query("SELECT p FROM Patient p WHERE p.first_name LIKE CONCAT('%', :query, '%')")
    List<Doctor> searchDoctors(String query);

    @Query("SELECT d.user_id, d.first_name, d.last_name FROM Doctor d")
    List<Object[]> getUserDropList();
}