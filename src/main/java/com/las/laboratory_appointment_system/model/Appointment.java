package com.las.laboratory_appointment_system.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    private LocalDateTime date_time;
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'SCHEDULED'")
    private String status;
    private String test_type;
    private String description;
}