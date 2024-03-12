package com.las.laboratory_appointment_system.model;

import com.las.laboratory_appointment_system.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Entity
@Table
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String password;
    private UserRole role;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String address;
    private String phone_number;
    private String email;
    @CreationTimestamp
    private LocalDateTime created_on;
    @UpdateTimestamp
    private LocalDateTime updated_on;
    private String insurance_provider;
    private String blood_type;

}
