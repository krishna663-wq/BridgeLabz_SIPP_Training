public class HotelBookingSystem {
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    public HotelBookingSystem() {
        this("Unknown", "Standard", 1);
    }

    // Parameterized constructor
    public HotelBookingSystem(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBookingSystem(HotelBookingSystem other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void display() {
        System.out.println("Guest: " + guestName + ", Room Type: " + roomType + ", Nights: " + nights);
    }
}