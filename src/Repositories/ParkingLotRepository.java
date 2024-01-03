package Repositories;

import models.Gate;
import models.GateType;
import models.ParkingLot;
import models.SpotAssignmentStrategyType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    //we can get parkinglot from frontend as well
    // but here we are fetching from DB from gate
    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    public ParkingLot getParkingLotFromGate(Gate gate){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.RANDOM_SPOT);
        Gate gate1 = new Gate();
        gate1.setGateNumber(1);
        gate1.setGateType(GateType.ENTRY);
//        gate.setGateStatus(Gate);
        List<Gate> gates = new ArrayList<>();
        gates.add(gate1);
        parkingLot.setGates(gates);
        parkingLots.put(45L,parkingLot);

        int gateNumber = gate.getGateNumber();
        for(ParkingLot parkingsLot: parkingLots.values()){
            for (Gate g:parkingsLot.getGates() ){
                if(g.getGateNumber() == gateNumber){
                    return parkingsLot;
                }
            }

        }

        return null;
    }
}
