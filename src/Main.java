import Controller.TicketController;
import DTO.IssueTicketRequestDto;
import DTO.IssueTicketResponseDto;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import Services.TicketService;
import models.Ticket;
import models.VehicleType;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository
        );

        TicketController ticketController = new TicketController(ticketService);



        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vehicle Owner Name");
        String OwnerName = sc.next();
        System.out.println("Enter the vehicle number");
        String vehicleNumber = sc.next();
        VehicleType vehicleType;
        System.out.println("Select the vehicle Type -");
        System.out.println("1. Two wheeler\n2. Four wheeler \n3. Truck \n4. Auto");
        int vehicleTypeChoice = sc.nextInt();
        switch (vehicleTypeChoice){
            case 1: vehicleType = VehicleType.TWO_WHEELER;break;
            case 2: vehicleType = VehicleType.FOUR_WHEELER;break;
            case 3: vehicleType = VehicleType.TRUCK;break;
            case 4: vehicleType = VehicleType.AUTO;break;
            default: vehicleType = VehicleType.FOUR_WHEELER;
        }

        System.out.println("Enter the Gate ID");
        Long gateId = sc.nextLong();


        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(gateId);
        requestDto.setVehicleNumber(vehicleNumber);
        requestDto.setVehicleOwnerName(OwnerName);
        requestDto.setVehicleType(vehicleType);

        IssueTicketResponseDto issueTicketResponseDto ;
        issueTicketResponseDto = ticketController.issueTicket(requestDto);

        System.out.println("Your ticket number is " + issueTicketResponseDto.getTicket().getNumber());
        //System.out.println("Your Entry time is " + issueTicketResponseDto.getTicket().getEntryTime());
    }
}