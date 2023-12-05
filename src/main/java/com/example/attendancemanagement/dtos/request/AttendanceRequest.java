package com.example.attendancemanagement.dtos.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AttendanceRequest {
    private String date;
    private String status;
    private String firstName;
    private String lastName;
}
