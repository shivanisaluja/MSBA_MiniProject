package org.ncu.hirewheels.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.repository.VehicleRepository;
import org.ncu.hirewheels.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public Vehicle registerVehicle(Vehicle vehicle) {
        try {
            return vehicleRepository.save(vehicle);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Vehicle changeAvailability(Integer vehicle_id) throws Exception {
        try {
            Optional<Vehicle> vehicle = vehicleRepository.findById(vehicle_id);
            if (vehicle.isPresent()) {
                Vehicle vehicle2 = vehicle.get();
                Integer curr_vehicle_availability = vehicle2.getAvailability_status();
                Integer vehicle_availability_toSet = curr_vehicle_availability == 1 ? 0 : 1;
                vehicle2.setAvailability_status(vehicle_availability_toSet);
                return vehicleRepository.save(vehicle2);
            }
            else {
                throw new Exception ("Vehicle Not Found");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
