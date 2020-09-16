package com.eldorado.appointment.controller;

import com.eldorado.appointment.payload.appointment.AppointmentRequest;
import com.eldorado.appointment.payload.appointment.AppointmentResponse;
import com.eldorado.appointment.payload.doctor.DoctorRequest;
import com.eldorado.appointment.payload.doctor.DoctorResponse;
import com.eldorado.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointment")
    public ResponseEntity<?> createAppointment(@Validated @RequestBody AppointmentRequest appointmentRequest) {
        AppointmentResponse appointmentResponse = appointmentService.createAppointment(appointmentRequest);
        return ResponseEntity.ok().body(appointmentResponse);
    }

    @GetMapping("/listAppointments")
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
}
