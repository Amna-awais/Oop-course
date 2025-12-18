package lab;

public class Park extends Commercial {
    private ShapeType shape;
    private double[] dimensions;
    
    public Park(String id, ShapeType shape, double[] dimensions) {
        super(id, 0); // Parks don't have a price
        this.shape = shape;
        this.dimensions = dimensions;
        this.area = calculateArea();
    }
    
    public double calculateArea() {
        switch (shape) {
            case RECTANGLE:
                return dimensions[0] * dimensions[1];
            case TRAPEZOID:
     return ((dimensions[0] + dimensions[1]) / 2) * dimensions[2];
            case L_SHAPE:
                return (dimensions[0] * dimensions[1]) + (dimensions[2] * dimensions[3]);
            default:
                return 0;
        }
    }
    
    // Getters
    public ShapeType getShape() { return shape; }
    public double[] getDimensions() { return dimensions; }
    
    @Override
    public String toString() {
        return String.format("Park %s (%s, %.2f sq units)",
                id, shape, area);
    }
}

