package strategies;

import models.SpotAssignmentStrategyType;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotForType(SpotAssignmentStrategyType spotAssignmentStrategyType){
        return new RandomSpotAssignmentStrategy();//creating object of RandomSlotAssignmentStrategy
    }
}
