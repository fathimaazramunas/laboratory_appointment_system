package com.las.laboratory_appointment_system.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private int id;
    private String username;
    private String email;
    private String password;
}
