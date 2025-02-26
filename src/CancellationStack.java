// To learn stacks in java
import java.util.Stack;
public class CancellationStack {
    private Stack<String> cancellations;

    public CancellationStack() {
        cancellations = new Stack<>();
    }

    public String cancelBooking(Ticket ticket) {
        Ticket.releaseSeat(ticket.getRow(), ticket.getCol());
        cancellations.push(ticket.buyTicket());
        return ticket.getMovie().getTitle() + " at " + ticket.getShowtime() + " has been cancelled.";
    }
}
