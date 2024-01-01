package strategies;

import models.ParkingSpot;
import models.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot getSpot(VehicleType vehicleType);

}
