package lab;

public class Commercial {
    protected String id;
    protected double area;
    protected long price;
    protected boolean available;
    
    public Commercial(String id, long price) {
        this.id = id;
        this.price = price;
        this.available = true;
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
    
    // Getters and setters
    public String getId() { return id; }
    public double getArea() { return area; }
    public long getPrice() { return price; }
    public boolean isAvailable() { return available; }

 
    @Override
    public String toString() {
        return String.format("Commercial %s (%.2f sq units, %d PKR, %s)",
                id, area, price, available ? "Available" : "Booked");
    }
}

    