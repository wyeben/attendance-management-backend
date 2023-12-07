package com.example.attendancemanagement.repository;

import com.example.attendancemanagement.model.AttendanceManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceManagementRepository extends JpaRepository<AttendanceManagement, Long> {

//    @Modifying
//    @Query("UPDATE User u SET u.firstName = :newName WHERE u.id = :id AND u.firstName = :firstName")
//    int updateUserById(@Param("id") Long id, @Param("firstName") String firstName, @Param("newName") String newName);
//
//    int deleteByUserId(Long id);
}
