package com.las.laboratory_appointment_system.mapper;

import com.las.laboratory_appointment_system.dto.AppointmentListViewDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentMapper {
    public static List<AppointmentListViewDto> mapObjToAppointmentListViewDto(List<Object[]> objectArray) {
        List<AppointmentListViewDto> appointmentList = new ArrayList<>();
        for (Object[] obj : objectArray) {
            AppointmentListViewDto dto = mapToObjectArrayToDto(obj);
            appointmentList.add(dto);
        }
        return appointmentList;
    }

    private static AppointmentListViewDto mapToObjectArrayToDto(Object[] obj) {
        int id = (int) obj[0];
        LocalDateTime dateTime = (LocalDateTime) obj[1];
        String description = (String) obj[2];
        String status = (String) obj[3];
        String testType = (String) obj[4];
        String doctorFirstName = (String) obj[5];
        String patientFirstName = (String) obj[6];
        return new AppointmentListViewDto(
                id,
                dateTime,
                description,
                status,
                testType,
                doctorFirstName,
                patientFirstName
        );
    }
}
