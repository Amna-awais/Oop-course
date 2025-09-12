
public class App {
    public static void main(String[] args) {
        // Creating Product objects using default constructor
        Product p1 = new Product();
        Product p2 = new Product();

        // Displaying initial details
        System.out.println("Initial Products:");
        p1.display();
        p2.display();

        // Update attributes using setters
        p1.setName("Laptop");
        p1.setId(101);
        p1.setPrice(999.99);
        p1.setInStock(true);

        p2.setName("Smartphone");
        p2.setId(102);
        p2.setPrice(499.49);
        p2.setInStock(false);

        
        System.out.println("Updated Products:");
        p1.display();
        p2.display();

        // Create Product using parameterized constructor
        Product p3 = new Product("Tablet", 103, 299.99, true);
        Product p4 = new Product("Headphones", 104, 59.99, false);

        
        System.out.println("Parameterized Products:");
        p3.display();
        p4.display();

        // Updating some attributes for p4
        p4.setPrice(49.99);
        p4.setInStock(true);

        System.out.println("Updated Headphones:");
        p4.display();
    }
}
