package com.example.attendancemanagement.services;

import com.example.attendancemanagement.dtos.request.Request;
import com.example.attendancemanagement.dtos.response.Response;
import com.example.attendancemanagement.model.User;
import com.example.attendancemanagement.repository.AttendanceManagementRepository;
import com.example.attendancemanagement.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceManagementService {
    private final AttendanceManagementRepository attendanceManagementRepository;
    private final UserRepository userRepository;

    @Autowired
    public AttendanceManagementService(AttendanceManagementRepository attendanceManagementRepository,
                                       UserRepository userRepository) {
        this.attendanceManagementRepository = attendanceManagementRepository;
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public Response registerUser(Request request) {
        User user = new User();
        user.setDate(request.getDate());
        user.setStatus(request.getStatus());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        userRepository.save(user);
        Response response = new Response();
        response.setMessage("Added successfully");
        return response;
    }

    @Transactional
    public ResponseEntity<String> updateUser(Long id, String userName, String newName) {
        int updatedCount = attendanceManagementRepository.updateUserById(id, userName, newName);

        if (updatedCount > 0) {
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.ok("Not found");
        }
    }

    @Transactional
    public ResponseEntity<String> deleteUser(Long id) {
        int successful = attendanceManagementRepository.deleteByUserId(id);
        if (successful > 0) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.ok("User not found");
        }
    }
//    @Transactional
//    public ResponseEntity<String> saveAttendanceAndUser(AttendanceRequest attendanceRequest) {
//        User user = userRepository.findByFirstNameAndLastName(attendanceRequest);
//
//        if (user == null) {
//            user = new User();
//            user.setFirstName(attendanceRequest.getFirstName());
//            user.setLastName(attendanceRequest.getLastName());
//            userRepository.save(user);
//        }
//
//        AttendanceManagement attendance = new AttendanceManagement();
//        attendance.setUser(user);
//        attendance.setDate(attendanceRequest.getDate());
//        attendance.setStatus(attendanceRequest.getStatus());
//        attendanceManagementRepository.save(attendance);
//
//        return ResponseEntity.ok("Attendance and User saved successfully");
//    }

}
