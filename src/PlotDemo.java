package lab;

public class PlotDemo {
    public static void main(String[] args) {
        // Create a regular plot
        Plot regularPlot = new Plot("1-001", PlotType.RES_5_MARLA, ShapeType.RECTANGLE, new double[]{25, 25});
        System.out.println(regularPlot);
        
        // Create a corner plot
        CornerPlot cornerPlot = new CornerPlot("1-004", PlotType.RES_5_MARLA, ShapeType.RECTANGLE, new double[]{25, 25}, 20);
        System.out.println(cornerPlot);
        
        // Test booking
        System.out.println("Booking regular plot: " + regularPlot.book());
        System.out.println(regularPlot);
        
        // Test double booking
        System.out.println("Booking regular plot again: " + regularPlot.book());
        
        // Test cancellation
        System.out.println("Canceling regular plot: " + regularPlot.cancel());
        System.out.println(regularPlot);
    }
}