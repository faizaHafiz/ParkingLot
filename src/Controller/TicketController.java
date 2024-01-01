package Controller;

import DTO.IssueTicketRequestDto;
import DTO.IssueTicketResponseDto;
import DTO.ResponseStatus;
import Services.TicketService;
import models.Ticket;

public class TicketController {
    private TicketService ticketService;//instantiate through DI
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto){

        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        Ticket ticket;
        try{
            ticket = ticketService.issueTicket(
                    issueTicketRequestDto.getVehicleType(),
                    issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getVehicleOwnerName(),
                    issueTicketRequestDto.getGateId()
            );
        } catch (Exception ex){
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILED);
            issueTicketResponseDto.setFailureReason(ex.getMessage());
            return issueTicketResponseDto;
        }
        issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        issueTicketResponseDto.setTicket(ticket);
        return null;
    }
}
