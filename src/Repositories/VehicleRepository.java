package Repositories;

import models.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> findVehicleByNumber(String number){
        return Optional.empty();
    }
    public Vehicle saveVehicle(Vehicle vehicle){
        // Vehicle which we are going to return will have an ID
        // vehicle which we accept through arguments wont have an ID
        return null;
    }
}
