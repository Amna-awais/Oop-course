package lab;

public class Shop extends Commercial {
    public Shop(String id, long price) {
        super(id, price);
    }
    
    @Override
    public String toString() {
        return String.format("Shop %s (%d PKR, %s)",
                id, price, available ? "Available" : "Booked");
    }
}
