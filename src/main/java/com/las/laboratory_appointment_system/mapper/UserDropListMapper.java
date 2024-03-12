package com.las.laboratory_appointment_system.mapper;

import com.las.laboratory_appointment_system.dto.AppointmentListViewDto;
import com.las.laboratory_appointment_system.dto.UserDropListDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDropListMapper {
    public static List<UserDropListDto> mapObjToUserDropListDto(List<Object[]> objectArray) {
        List<UserDropListDto> userDropList = new ArrayList<>();
        for (Object[] obj : objectArray) {
            UserDropListDto dto = mapToObjectArrayToDto(obj);
            userDropList.add(dto);
        }
        return userDropList;
    }

    private static UserDropListDto mapToObjectArrayToDto(Object[] obj) {
        int id = (int) obj[0];
        String FirstName = (String) obj[1];
        String LastName = (String) obj[2];
        return new UserDropListDto(
                id,
                FirstName,
                LastName
        );
    }
}
