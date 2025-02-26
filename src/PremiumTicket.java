public class PremiumTicket extends Ticket{
    private double premiumFee = 5.0;

    // Constructor
    public PremiumTicket(Movie movie, String showtime, int row, int col, double price) {
        super(movie, showtime, row, col, price); // super refers to the parent class
    }

    // You can buy a premium ticket even if the seat is already taken
    @Override
    public String buyTicket() {
        return "Ticket for " + getMovie().getTitle() + " at " + getShowtime() + " for " + super.getPrice() + premiumFee + " has been purchased.";

    }

    @Override
    public double getPrice() {
        return super.getPrice() + premiumFee;

    }
}
