package com.example.attendancemanagement.repository;

import com.example.attendancemanagement.dtos.request.AttendanceRequest;
import com.example.attendancemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("UPDATE User u SET u.firstName = :newName WHERE u.id = :id AND u.firstName = :firstName")
    int updateUserById(@Param("id") Long id, @Param("firstName") String firstName, @Param("newName") String newName);


    int deleteByUserId(Long id);
}
