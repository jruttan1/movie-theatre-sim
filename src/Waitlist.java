// To learn linked lists in java
import java.util.LinkedList;
import java.util.Queue;

public class Waitlist {
    private Queue<String> waitlist; //

    public Waitlist() {
        waitlist = new LinkedList<>(); //LinkedList implements the Queue interface
    }

    public String addCustomer(String customerName) {
        waitlist.add(customerName);
        return customerName + " has been added to the waitlist.";
    }

    public String removeCustomer() {
        if (waitlist.isEmpty()) {
            return "The waitlist is empty.";
        }
        return waitlist.remove() + " has been removed from the waitlist.";
    }

    public String viewNextCustomer() {
        return waitlist.peek() + " is next in line.";
    }

    public int getWaitlistSize() {
        return waitlist.size();
    }

    public void printWaitlist() {
        if (waitlist.isEmpty()) {
            System.out.println("The waitlist is empty.");
        } else {
            for (String customer : waitlist) {
                System.out.print(customer + ", ");
            }
        }
    }



}
