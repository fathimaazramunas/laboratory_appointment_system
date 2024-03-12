package com.las.laboratory_appointment_system.dto;

import com.las.laboratory_appointment_system.enums.UserRole;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private int user_id;
    private String username;
    private UserRole role;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String address;
    private String phone_number;
    private String email;
    private String insurance_provider;
    private String blood_type;
}
