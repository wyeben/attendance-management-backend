package com.example.attendancemanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AttendanceManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
