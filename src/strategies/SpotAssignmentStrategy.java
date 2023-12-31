package strategies;

import models.Gate;
import models.ParkingSpot;
import models.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot getSpot(VehicleType vehicleType, Gate gate);

}
