package Repositories;

import models.Gate;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    //we can get parkinglot from frontend as well
    // but here we are fetching from DB from gate
    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    public ParkingLot getParkingLotFromGate(Gate gate){
        for(ParkingLot parkingLot: parkingLots.values()){
            if(parkingLot.getGates().contains(gate)){
                return parkingLot;
            }
        }

        return null;
    }
}
