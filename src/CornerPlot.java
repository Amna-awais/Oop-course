package lab;

public class CornerPlot extends Plot {
    private double secondWidth;
    
    public CornerPlot(String id, PlotType type, ShapeType shape, double[] dimensions, double secondWidth) {
        super(id, type, shape, dimensions);
        this.secondWidth = secondWidth;
        this.price = (long) (type.getBasePrice() * 1.08); // 8% premium
    }
    
    @Override
    public double calculateArea() {
        double baseArea = super.calculateArea();
        // Add area from second frontage
        return baseArea + (secondWidth * dimensions[1]);
    }
    
    @Override
    public String toString() {
        return String.format("CornerPlot %s (%s, %s, %.2f sq units, %d PKR, %s)",
                id, type, shape, area, price, available ? "Available" : "Booked");
    }
}