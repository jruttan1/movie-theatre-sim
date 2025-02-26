public class Ticket {
    private Movie movie;
    private String showtime;
    private int row;
    private int col;
    private double price;

    // Creates size of theater
    public static String[][] seats = new String[10][15]; // 2D array of seats size 10x15

    static { // static block that initializes the seat array as being all available
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = "0";
            }
        }
    }

    // Constructor
    public Ticket(Movie movie, String showtime, int row, int col, double price) {
        this.movie = movie;
        this.showtime = showtime;
        this.row = row;
        this.col = col;
    }

    // Method to reserve a seat
    public boolean isAvailable(int row, int col) {
        if (row >= 0 && row < seats.length && col >= 0 && col < seats[0].length) {
            if (seats[row][col].equals("0")) {
                seats[row][col] = "1";
                return true;
            }
        }
        return false;
    }

    // Method to buy a ticket based on isAvailable
    public String buyTicket() {
        if (isAvailable(row, col)) {
            return "Ticket for " + movie.getTitle() + " at " + showtime + " for " + price + " has been purchased.";
        } else {
            return "Seat is already taken.";
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public String getShowtime() {
        return showtime;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;

    }

    public double getPrice() {
        return 10.0;
    }
}

