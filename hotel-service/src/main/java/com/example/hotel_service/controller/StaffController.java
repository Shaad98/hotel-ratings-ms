package com.example.hotel_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping
    public ResponseEntity<List<String>> getStaffs()
    {
        List<String> staffsList = List.of("Karan","Pavan","Ravi");
        return ResponseEntity.ok(staffsList);
    }
}
