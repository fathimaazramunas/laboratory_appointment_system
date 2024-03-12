package com.las.laboratory_appointment_system.service;

import com.las.laboratory_appointment_system.dto.AppointmentListViewDto;
import com.las.laboratory_appointment_system.dto.DoctorDto;
import com.las.laboratory_appointment_system.model.Appointment;
import com.las.laboratory_appointment_system.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<AppointmentListViewDto> getAllAppointments();

    Appointment createAppointment(Appointment appointment);

    Appointment getAppointmentById(int doctorId);

    Appointment saveAppointment(Appointment appointment);

    Appointment findAppointmentById(int id);

    void delete(int id);

    void updateAppointment(Appointment appointment);
}
