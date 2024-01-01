package Services;

import Exceptions.GateNotFoundException;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import models.*;
import strategies.SpotAssignmentStrategy;
import strategies.SpotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository
                        ) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(VehicleType vehicleType,
                              String vehicleNumber,
                              String OwnerName,
                              Long gateId) throws GateNotFoundException {
        /*
        * 1. Create ticket
        * 2. Assign Spot
        * 3. return ticket
        * */
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date()); //we are setting time

        //using gateid we can get whole gate object. gate object is stored in DB
        // to connect to DB we need repositories
        // the reason Optional exists is because we want to avoid nullPointer exception
        Optional<Gate> gateOptional = gateRepository.findByGateId(gateId);
        if(gateOptional.isEmpty()){ // if you are not checking then you will get warning
            throw new GateNotFoundException();
        }

        Gate gate = gateOptional.get();//to get gate
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        //vehicle
        // check if vehicle is already in DB
        // if yes, get vehicle from DB put it in ticket object
        // else create new vehicle
        // save it to Db
        // put it in ticket object
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(optionalVehicle.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(OwnerName);
            // if you wat to handle vehicle owner change here logic can be added

            savedVehicle = vehicleRepository.saveVehicle(vehicle);

        }else{
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        //assign spot - spot assignment strategy
        SpotAssignmentStrategyType spotAssignmentStrategyType =
                parkingLotRepository.getParkingLotFromGate(gate).getSpotAssignmentStrategyType();

        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.
                getSpotForType(spotAssignmentStrategyType);

        ticket.setParkingSpot(
                spotAssignmentStrategy.getSpot(vehicleType)
        );

        Ticket savedTicket = ticketRepository.saveTicket(ticket);
        ticket.setNumber("Ticket-"+ savedTicket.getId());

        return savedTicket;

    }
}
