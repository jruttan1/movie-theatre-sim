public class PremiumTicket extends Ticket{
    private double premiumPrice;

    public PremiumTicket(Movie movie, String showtime, int row, int col, double price) {
        super(movie, showtime, row, col, price);
    }
}
