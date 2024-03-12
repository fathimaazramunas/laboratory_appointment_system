    package com.las.laboratory_appointment_system.dto;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class AppointmentListViewDto {
        private int id;
        private LocalDateTime date_time;
        private String description;
        private String status;
        private String test_type;
        private String d_first_name;
        private String p_first_name;
    }
