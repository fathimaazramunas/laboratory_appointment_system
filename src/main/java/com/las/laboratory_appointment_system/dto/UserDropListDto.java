package com.las.laboratory_appointment_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDropListDto {
    private int user_id;
    private String first_name;
    private String last_name;
}
