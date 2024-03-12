package com.las.laboratory_appointment_system.repository;

import com.las.laboratory_appointment_system.dto.UserDropListDto;
import com.las.laboratory_appointment_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    //    Optional<Patient> findByFirst_name(String url);
    @Query("SELECT p FROM Patient p WHERE p.first_name LIKE CONCAT('%', :query, '%')")
    List<Patient> searchPatients(String query);

    @Query("SELECT p.user_id, p.first_name, p.last_name FROM Patient p")
    List<Object[]> getUserDropList();
}