package sp25_bcs_011;

public class CinemaDemo {
    public static void main(String[] args) {
        // Create cities with fixed capacity
        CityCinema karachi = new CityCinema("Karachi", 2);
        CityCinema lahore = new CityCinema("Lahore", 2);
        CityCinema islamabad = new CityCinema("Islamabad", 1);

        // Add cinemas to Karachi
        Cinema atrium = new Cinema("Atrium Saddar", 2);
        Cinema nueplex = new Cinema("Nueplex DHA", 2);
        karachi.addCinema(atrium);
        karachi.addCinema(nueplex);

        // Add cinemas to Lahore
        Cinema township = new Cinema("CineStar Township", 2);
        Cinema gulberg = new Cinema("CineStar Gulberg", 2);
        lahore.addCinema(township);
        lahore.addCinema(gulberg);

        // Add cinema to Islamabad
        Cinema centaurus = new Cinema("Centaurus Megaplex", 2);
        islamabad.addCinema(centaurus);

        // Print initial layouts
        System.out.println("=== Initial Layouts ===");
        karachi.printCityLayouts();
        lahore.printCityLayouts();
        islamabad.printCityLayouts();

        // Book seat 3-007 in Karachi > Atrium Saddar > Screen-1
        System.out.println("\n=== Booking Seat 3-007 in Karachi > Atrium Saddar > Screen-1 ===");
        boolean booked = karachi.bookSeat(0, 0, "3-007");
        System.out.println("Booking successful: " + booked);

        // Attempt to book the same seat again
        System.out.println("\n=== Attempting Double Booking ===");
        boolean doubleBooked = karachi.bookSeat(0, 0, "3-007");
        System.out.println("Second booking attempt: " + (doubleBooked ? "Success" : "Failed"));

        // Cancel the booking
        System.out.println("\n=== Canceling Seat 3-007 ===");
        boolean canceled = karachi.cancelSeat(0, 0, "3-007");
        System.out.println("Cancellation successful: " + canceled);

        // Book another seat to show [X] in layout
        System.out.println("\n=== Booking Seat 2-005 in Karachi > Atrium Saddar > Screen-1 ===");
        boolean bookedSecond = karachi.bookSeat(0, 0, "2-005");
        System.out.println("Booking successful: " + bookedSecond);

        // Print updated layout for Karachi
        System.out.println("\n=== Updated Layout for Karachi ===");
        karachi.printCityLayouts();

        // Search for first available VIP seat in Lahore
        System.out.println("\n=== Searching for First Available VIP Seat in Lahore ===");
        String vipSeat = lahore.findFirstAvailableVIP();
        System.out.println("First available VIP seat: " + vipSeat);
    }
}
