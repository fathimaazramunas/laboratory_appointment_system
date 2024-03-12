package com.las.laboratory_appointment_system.repository;

import com.las.laboratory_appointment_system.model.Doctor;
import com.las.laboratory_appointment_system.model.LabTechnician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LabTechnicianRepository extends JpaRepository<LabTechnician, Integer> {
    @Query("SELECT p FROM Patient p WHERE p.first_name LIKE CONCAT('%', :query, '%')")
    List<LabTechnician> searchLabTechnicians(String query);
}