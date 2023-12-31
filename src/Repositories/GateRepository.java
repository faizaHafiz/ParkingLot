package Repositories;

import models.Gate;
import models.GateType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    //handles anything that revolves around gate object

    //if we dont find gate by that id we return null
    //but if we return null we get nullpointer exception
    // so we return Optional
    // think of optional as a wrapper around Gate
    // we have to go inside optional and check if gate is present or not

    private Map<Long,Gate> gates = new HashMap<>();

    public Optional<Gate> findByGateId(Long id){
        Gate gate = new Gate();
        gate.setGateNumber(1);
        gate.setGateType(GateType.ENTRY);
//        gate.setGateStatus(Gate);
        gates.put(45L,gate);
        if(gates.containsKey(id)){
            return Optional.of(gates.get(id));
        }
        return Optional.empty();
    }
}
