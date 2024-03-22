package com.las.laboratory_appointment_system.repository;

import com.las.laboratory_appointment_system.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM appointment WHERE patient_user_id = :patientId", nativeQuery = true)
    void deleteAppointmentByPatientId(int patientId);

    @Query("DELETE FROM Appointment a WHERE a.patient.user_id = :doctorId")
    void deleteAppointmentByDoctorId(int doctorId);
}
