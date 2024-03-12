package com.las.laboratory_appointment_system.repository;

import com.las.laboratory_appointment_system.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query("SELECT a.id, a.date_time, a.description, a.status, a.test_type, " +
            "p.first_name AS patient_first_name, " +
            "d.first_name AS doctor_first_name " +
            "FROM Appointment a " +
            "JOIN Patient p " +
            "ON a.patient.user_id = p.user_id " +
            "JOIN Doctor d " +
            "ON a.doctor.user_id = d.user_id")
    List<Object[]> sa();


}
