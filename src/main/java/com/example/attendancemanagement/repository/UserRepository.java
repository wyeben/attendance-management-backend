package com.example.attendancemanagement.repository;

import com.example.attendancemanagement.dtos.request.AttendanceRequest;
import com.example.attendancemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByFirstNameAndLastName(String firstName, String lastName);
//
//    User findByFirstNameAndLastName(String firstName, String lastName);
//
//    User findByFirstNameAndLastName(AttendanceRequest attendanceRequest);
//
//
//    User findByFirstNameAndLastName(AttendanceRequest attendanceRequest);

}
