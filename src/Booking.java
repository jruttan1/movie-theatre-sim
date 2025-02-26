import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<Ticket> tickets;
    private String customerName;

    public Booking(String customerName) {
        this.customerName = customerName;
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderTotal() {
        double total = 0;
        for (Ticket ticket : tickets) { // for each ticket in tickets
            total += ticket.getPrice(); // add the price of the ticket to the total
        }
        return total;
    }

    public void orderSummary() {
        System.out.println("Booking for: " + customerName);
        for (Ticket ticket : tickets) {
            System.out.println(ticket.buyTicket());
        }
        System.out.println("Total Price: $" + getOrderTotal());
    }
}





