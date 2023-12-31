package Repositories;

import models.Gate;

import java.util.Optional;

public class GateRepository {
    //handles anything that revolves around gate object

    //if we dont find gate by that id we return null
    //but if we return null we get nullpointer exception
    // so we return Optional
    // think of optional as a wrapper around Gate
    // we have to go inside optional and check if gate is present or not
    public Optional<Gate> findByGateId(Long id){
        return Optional.empty();
    }
}
