package strategies;

import models.Gate;
import models.ParkingSpot;
import models.VehicleType;

public interface SlotAssignmentStrategy {
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType);
    
}
