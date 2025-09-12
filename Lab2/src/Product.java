
public class Product {
    private String name;
    private int id;
    private double price;
    private boolean inStock;

    // Default constructor
    public Product() {
        this.name = "Unknown";
        this.id = 0;
        this.price = 0.0;
        this.inStock = false;
    }

    // Parameterized constructor
    public Product(String name, int id, double price, boolean inStock) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.inStock = inStock;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    // Display method
    public void display() {
        System.out.println("Product Details:");
        System.out.println("----------------");
        System.out.println("Name       : " + name);
        System.out.println("ID         : " + id);
        System.out.println("Price      : $" + price);
        System.out.println("In Stock?  : " + (inStock ? "Yes" : "No"));
        System.out.println();
    }
}
