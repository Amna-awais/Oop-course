package sp25_bcs_011;

public class Seat {
    public enum SeatType {
        REGULAR, PREMIUM, VIP, RECLINER
    }

    private String id;
    private SeatType type;
    private double price;
    private boolean available;

    public Seat(String id, SeatType type) {
        this.id = id;
        this.type = type;
        this.available = true;
        switch (type) {
           case REGULAR: this.price = 500; break;
           case PREMIUM: this.price = 750; break;
           case VIP: this.price = 1000; break;
           case RECLINER: this.price = 1200; break;
        }
    }

    public String getId() {
        return id;
   }

    public SeatType getType() {
        return type;
   }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
   }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean book() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    public boolean cancel() {
        if (!available) {
            available = true;
            return true;
        }
        return false;
    }

    public String toString() {
        return id + " (" + type + ", " + price + " PKR, " + (available ? "Available" : "Booked") + ")";
    }
}
