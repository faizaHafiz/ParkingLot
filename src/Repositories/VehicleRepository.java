package Repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<String,Vehicle> vehicleMap = new HashMap<>();//vehicle number- vehicle obj
    public Optional<Vehicle> findVehicleByNumber(String number){
        if(vehicleMap.get(number)!=null){
            return Optional.of(vehicleMap.get(number));
        }
        return Optional.empty();
    }
    public Vehicle saveVehicle(Vehicle vehicle){
        // Vehicle which we are going to return will have an ID
        // vehicle which we accept through arguments wont have an ID
        vehicleMap.put(vehicle.getNumber(),vehicle);
        Vehicle vehicle1 = vehicleMap.get(vehicle.getNumber());
        return vehicle1;
    }
}
