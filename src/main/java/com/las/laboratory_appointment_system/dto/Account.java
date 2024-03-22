package com.las.laboratory_appointment_system.dto;

import com.las.laboratory_appointment_system.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private String username;
    private String password;
}
