package com.example.attendancemanagement.controller;


import com.example.attendancemanagement.dtos.request.AttendanceRequest;
import com.example.attendancemanagement.dtos.request.Request;
import com.example.attendancemanagement.dtos.response.Response;
import com.example.attendancemanagement.model.AttendanceManagement;
import com.example.attendancemanagement.model.User;
import com.example.attendancemanagement.services.AttendanceManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/attendance-management")
public class AttendanceManagementController {
    private final AttendanceManagementService attendanceManagementService;

    public AttendanceManagementController(AttendanceManagementService attendanceManagementService) {
        this.attendanceManagementService = attendanceManagementService;
    }
//    @GetMapping("home")
//    @ResponseBody
//    public String  getHomePage(Model model){
//        model.addAttribute("message", "Hello from Spring Boot");
//
//        return "index";
//    }
    @GetMapping("users")
    public List<User> getAllUser() {
        return attendanceManagementService.getUsers();
    }

    @PostMapping("register")
    public Response registerUsers(@RequestBody Request request) {
        return attendanceManagementService.registerUser(request);
    }

    @PutMapping("update-user/{id}/{userName}/{newName}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id,
                                                    @PathVariable String userName,
                                                    @PathVariable String newName) {
        return attendanceManagementService.updateUser(id, userName, newName);
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId) {
        return attendanceManagementService.deleteUser(userId);
    }
//    @PostMapping("save-attendance")
//    public ResponseEntity<String> saveAttendance(@RequestBody AttendanceRequest attendanceRequest) {
//        return attendanceManagementService.saveAttendanceAndUser(attendanceRequest);
//    }

}
