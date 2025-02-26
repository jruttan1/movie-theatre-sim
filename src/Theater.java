import java.util.Scanner;
public class Theater {

    public static void main(String[] args) {
        testMovie();
        testTicket();
        testPremiumTicket();
        testBooking();
        testWaitlist();
        testCancellationStack();
    }

    // Test the Movie class by creating an Inception movie and printing its details.
    public static void testMovie() {
        System.out.println("---- Testing Movie ----");
        String[] actors = {"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page", "Tom Hardy"};
        Movie inception = new Movie("Inception", "Action, Adventure, Sci-Fi", 148, "PG-13", 8.8, "Christopher Nolan", actors, 2010);
        System.out.println("Title: " + inception.getTitle());
        System.out.println("Genre: " + inception.getGenre());
        System.out.println("Rating: " + inception.getRating());
        System.out.println("Score: " + inception.getScore());
        System.out.println("Director: " + inception.getDirector());
        System.out.println("Year: " + inception.getYear());
        System.out.println("ToString: " + inception.toString());
        System.out.println();
    }

    // Test the Ticket class by reserving a seat and trying to reserve the same seat again.
    public static void testTicket() {
        System.out.println("---- Testing Ticket ----");
        String[] actors = {"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page", "Tom Hardy"};
        Movie inception = new Movie("Inception", "Action, Adventure, Sci-Fi", 148, "PG-13", 8.8, "Christopher Nolan", actors, 2010);

        // Ensure seat [1][1] is available before testing.
        Ticket.releaseSeat(1, 1);

        // Create a Ticket for seat [1][1] and attempt to buy it.
        Ticket ticket1 = new Ticket(inception, "7:00 PM", 1, 1, 10.0);
        String result1 = ticket1.buyTicket();
        System.out.println("First purchase attempt: " + result1);

        // Create another Ticket for the same seat; should report seat taken.
        Ticket ticket2 = new Ticket(inception, "7:00 PM", 1, 1, 10.0);
        String result2 = ticket2.buyTicket();
        System.out.println("Second purchase attempt (should be taken): " + result2);

        // Release the seat and try again.
        Ticket.releaseSeat(1, 1);
        String result3 = ticket2.buyTicket();
        System.out.println("After releasing, purchase attempt: " + result3);
        System.out.println();
    }

    // Test the PremiumTicket class to ensure premium pricing and ticket message are correct.
    public static void testPremiumTicket() {
        System.out.println("---- Testing PremiumTicket ----");
        String[] actors = {"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page", "Tom Hardy"};
        Movie inception = new Movie("Inception", "Action, Adventure, Sci-Fi", 148, "PG-13", 8.8, "Christopher Nolan", actors, 2010);

        // Ensure seat [2][2] is available.
        Ticket.releaseSeat(2, 2);

        PremiumTicket premiumTicket = new PremiumTicket(inception, "7:00 PM", 2, 2, 10.0);
        String premiumResult = premiumTicket.buyTicket();
        System.out.println(premiumResult);
        System.out.println("Premium Ticket Price: $" + premiumTicket.getPrice());
        System.out.println();
    }

    // Test the Booking class by adding tickets and printing the order summary.
    public static void testBooking() {
        System.out.println("---- Testing Booking ----");
        String[] actors = {"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page", "Tom Hardy"};
        Movie inception = new Movie("Inception", "Action, Adventure, Sci-Fi", 148, "PG-13", 8.8, "Christopher Nolan", actors, 2010);
        Booking booking = new Booking("John Doe");

        // Ensure seats [3][3] and [3][4] are available.
        Ticket.releaseSeat(3, 3);
        Ticket.releaseSeat(3, 4);

        Ticket ticket = new Ticket(inception, "7:00 PM", 3, 3, 10.0);
        PremiumTicket premiumTicket = new PremiumTicket(inception, "7:00 PM", 3, 4, 10.0);
        booking.addTicket(ticket);
        booking.addTicket(premiumTicket);

        booking.orderSummary();
        System.out.println();
    }

    // Test the Waitlist class by adding, viewing, and removing customers.
    public static void testWaitlist() {
        System.out.println("---- Testing Waitlist ----");
        Waitlist waitlist = new Waitlist();
        System.out.println(waitlist.addCustomer("Alice"));
        System.out.println(waitlist.addCustomer("Bob"));
        System.out.println("Next in line: " + waitlist.viewNextCustomer());
        System.out.println("Waitlist Size: " + waitlist.getWaitlistSize());
        System.out.print("Current waitlist: ");
        waitlist.printWaitlist();
        System.out.println();
        System.out.println(waitlist.removeCustomer());
        System.out.println("Waitlist Size after removal: " + waitlist.getWaitlistSize());
        System.out.println();
    }

    // Test the CancellationStack by cancelling a ticket and printing cancelled tickets.
    public static void testCancellationStack() {
        System.out.println("---- Testing CancellationStack ----");
        String[] actors = {"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page", "Tom Hardy"};
        Movie inception = new Movie("Inception", "Action, Adventure, Sci-Fi", 148, "PG-13", 8.8, "Christopher Nolan", actors, 2010);

        // Ensure seat [4][4] is available.
        Ticket.releaseSeat(4, 4);

        Ticket ticket = new Ticket(inception, "7:00 PM", 4, 4, 10.0);
        // Purchase the ticket (reserve seat).
        System.out.println(ticket.buyTicket());

        CancellationStack cancellationStack = new CancellationStack();
        String cancelMessage = cancellationStack.cancelBooking(ticket);
        System.out.println(cancelMessage);
        System.out.println();

        // Before any bookings, the seating chart should be all "0" (available).
        System.out.println("Initial Seating Chart:");
        printSeatingChart();

        // Make some bookings:
        // Book seat [1][2] with a regular ticket.
        Ticket ticket1 = new Ticket(inception, "7:00 PM", 1, 2, 10.0);
        System.out.println("\nBooking seat [1][2]: " + ticket1.buyTicket());

        // Book seat [3][4] with a regular ticket.
        Ticket ticket2 = new Ticket(inception, "7:00 PM", 3, 4, 10.0);
        System.out.println("Booking seat [3][4]: " + ticket2.buyTicket());

        // Book seat [5][6] with a premium ticket.
        PremiumTicket premiumTicket = new PremiumTicket(inception, "7:00 PM", 5, 6, 10.0);
        System.out.println("Booking seat [5][6] with PremiumTicket: " + premiumTicket.buyTicket());

        // Display the visual representation of the seating chart after bookings.
        System.out.println("\nSeating Chart After Bookings:");
        printSeatingChart();
    }

    // Utility method to print out the theater seating chart in a grid format.
    public static void printSeatingChart() {
        for (int i = 0; i < Ticket.seats.length; i++) {
            for (int j = 0; j < Ticket.seats[i].length; j++) {
                System.out.print(Ticket.seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}

