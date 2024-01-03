package strategies;

import models.Gate;
import models.ParkingSpot;
import models.VehicleType;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    @Override
    public ParkingSpot getSpot(VehicleType vehicleType, Gate gate) {
        //parkinglot--> parkingfloor --> parkingspot
        //
        return null;
    }
}
