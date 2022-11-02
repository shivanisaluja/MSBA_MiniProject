package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping(value = "/vehicles", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle curr_vehicle = adminService.registerVehicle(vehicle);
            return new ResponseEntity<Vehicle>(curr_vehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            throw e;
        }

    }

    @PutMapping(value = "/vehicles/{vehicle_id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Integer vehicle_id) throws Exception {
        try {
            Vehicle curr_vehicle = adminService.changeAvailability(vehicle_id);
            return new ResponseEntity<Vehicle>(curr_vehicle, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw e;
        }

    }
}
