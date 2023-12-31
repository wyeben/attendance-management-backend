package com.example.attendancemanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user", indexes = {
        @Index(name = "idx_user_id", columnList = "id")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    private String date;
    private String status;
    private String firstName;
    private String lastName;
}
