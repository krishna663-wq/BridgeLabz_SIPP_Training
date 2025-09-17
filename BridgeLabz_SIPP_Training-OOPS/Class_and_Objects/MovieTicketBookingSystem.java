public class MovieTicketBookingSystem {
    String movieName;
    int seatNumber;
    double price;

    // Method to book a ticket
    public void bookTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Method to display ticket details
    public void displayTicketDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Ticket Price: " + price);
    }

    // Main method to test the class
    public static void main(String[] args) {
        MovieTicketBookingSystem ticket = new MovieTicketBookingSystem();
        ticket.bookTicket("Inception", 45, 250);
        ticket.displayTicketDetails();
    }
}