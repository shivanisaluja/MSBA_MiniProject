package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;

public interface AdminService {
    public Vehicle registerVehicle(Vehicle vehicle);
    public Vehicle changeAvailability(Integer vehicle_id) throws Exception;
}
