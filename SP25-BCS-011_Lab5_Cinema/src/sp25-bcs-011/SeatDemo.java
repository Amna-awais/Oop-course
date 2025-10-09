package sp25_bcs_011;

public class SeatDemo {
    public static void main(String[] args) {
        // Create seats of different types
        Seat regular = new Seat("1-001", Seat.SeatType.REGULAR);
        Seat premium = new Seat("2-005", Seat.SeatType.PREMIUM);
        Seat vip = new Seat("3-007", Seat.SeatType.VIP);
        Seat recliner = new Seat("4-010", Seat.SeatType.RECLINER);

        // Print initial state
        System.out.println("Initial Seats:");
        System.out.println(regular);
        System.out.println(premium);
        System.out.println(vip);
        System.out.println(recliner);

        // Book some seats
        System.out.println("\nBooking Seats:");
        regular.book();
        vip.book();

        // Try booking again to test rejection
        boolean secondBooking = vip.book();
        System.out.println("Second booking attempt for VIP seat: " + (secondBooking ? "Success" : "Failed"));

        // Cancel a booking
        System.out.println("\nCanceling VIP seat:");
        vip.cancel();

        // Adjust price
        System.out.println("\nAdjusting price for Recliner:");
        recliner.setPrice(1500);

        // Final state
        System.out.println("\nFinal Seats:");
        System.out.println(regular);
        System.out.println(premium);
        System.out.println(vip);
        System.out.println(recliner);
    }
}

