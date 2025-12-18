package lab;

public class Block {
    private String name;
    private Plot[][] plots;
    private Park[] parks;
    private CommercialMarket market;
    
    public Block(String name) {
        this.name = name;
        this.plots = new Plot[5][]; // 5 streets
        
        // Initialize jagged array with increasing lengths
        for (int i = 0; i < 5; i++) {
            plots[i] = new Plot[10 + i]; // Streets 1-5 have 10-14 plots
        }
        
        // Initialize plots based on street type
        initializePlots();
        
        // Initialize parks (1-2 parks per block)
        this.parks = new Park[2];
        parks[0] = new Park(name + "-Park1", ShapeType.RECTANGLE, new double[]{50, 30});
        if (Math.random() > 0.5) { // 50% chance of a second park
            parks[1] = new Park(name + "-Park2", ShapeType.RECTANGLE, new double[]{40, 25});
        }
        
        // Initialize market
        this.market = new CommercialMarket(name + "-Market", 12 + (int)(Math.random() * 9)); // 12-20 shops
    }
    
    private void initializePlots() {
        for (int street = 0; street < 5; street++) {
            for (int plot = 0; plot < plots[street].length; plot++) {
                String plotId = (street + 1) + "-" + String.format("%03d", plot + 1);
                PlotType type;
                ShapeType shape;
                double[] dimensions;
                
                // Determine plot type based on street
                switch (street) {
                    case 0: // Street 1
                        type = PlotType.RES_5_MARLA;
                        shape = ShapeType.RECTANGLE;
                        dimensions = new double[]{25, 25};
                        break;
                    case 1: // Street 2
                        type = PlotType.RES_10_MARLA;
                        shape = ShapeType.RECTANGLE;
                        dimensions = new double[]{35, 35};
                        break;
                    case 2: // Street 3
                        type = PlotType.RES_1_KANAL;
                        shape = ShapeType.TRAPEZOID;
                        dimensions = new double[]{40, 50, 40};
                        break;
                    case 3: // Street 4
                        type = PlotType.COMM_SHOP;
                        shape = ShapeType.RECTANGLE;
                        dimensions = new double[]{20, 20};
                        break;
                    case 4: // Street 5
                        type = PlotType.COMM_OFFICE;
                        shape = ShapeType.RECTANGLE;
                        dimensions = new double[]{30, 30};
                        break;
                    default:
                        type = PlotType.PARKING;
                        shape = ShapeType.RECTANGLE;
                        dimensions = new double[]{10, 10};
                }
                
                // Every 5th plot is parking
                if ((plot + 1) % 5 == 0) {
                    type = PlotType.PARKING;
                    shape = ShapeType.RECTANGLE;
                    dimensions = new double[]{10, 10};
                }
                
                // Create plot or corner plot
                if (street < 3 && (plot + 1) % 4 == 0) { // Every 4th plot on streets 1-3 is a corner plot
                    double secondWidth = dimensions[0] * 0.8; // Second frontage is 80% of the first
                    plots[street][plot] = new CornerPlot(plotId, type, shape, dimensions, secondWidth);
                } else {
                    plots[street][plot] = new Plot(plotId, type, shape, dimensions);
                }
            }
        }
    }
    
    public boolean bookPlot(String plotId) {
        String[] parts = plotId.split("-");
        int street = Integer.parseInt(parts[0]) - 1;
        int plot = Integer.parseInt(parts[1]) - 1;
        
        if (street >= 0 && street < plots.length && plot >= 0 && plot < plots[street].length) {
            return plots[street][plot].book();
        }
        return false;
    }
    
    public boolean cancelPlot(String plotId) {
        String[] parts = plotId.split("-");
        int street = Integer.parseInt(parts[0]) - 1;
        int plot = Integer.parseInt(parts[1]) - 1;
        
        if (street >= 0 && street < plots.length && plot >= 0 && plot < plots[street].length) {
            return plots[street][plot].cancel();
        }
        return false;
    }
    
    public Plot[] getPlotsByType(PlotType type) {
        // First pass: count plots of the specified type
        int count = 0;
        for (int street = 0; street < plots.length; street++) {
            for (int plot = 0; plot < plots[street].length; plot++) {
                if (plots[street][plot].getType() == type) {
                    count++;
                }
            }
        }
        
        // Second pass: allocate and fill
        Plot[] result = new Plot[count];
        int index = 0;
        for (int street = 0; street < plots.length; street++) {
            for (int plot = 0; plot < plots[street].length; plot++) {
                if (plots[street][plot].getType() == type) {
                    result[index++] = plots[street][plot];
                }
            }
        }
        
        return result;
    }
    
    public void printStreetLayout() {
        System.out.println("Block " + name + " Street Layout:");
        for (int street = 0; street < plots.length; street++) {
            System.out.print("Street " + (street + 1) + ": ");
            for (int plot = 0; plot < plots[street].length; plot++) {
                System.out.print(plots[street][plot].isAvailable() ? "A " : "X ");
            }
            System.out.println();
        }
    }
    
    public void printDetails() {
        System.out.println("Block " + name + " Details:");
        for (int street = 0; street < plots.length; street++) {
            for (int plot = 0; plot < plots[street].length; plot++) {
                System.out.println(plots[street][plot]);
            }
        }
        
        System.out.println("\nAmenities:");
        for (int i = 0; i < parks.length && parks[i] != null; i++) {
            System.out.println(parks[i]);
        }
        System.out.println(market);
    }
    
    // Getters
    public String getName() { return name; }
    public Plot[][] getPlots() { return plots; }
    public Park[] getParks() { return parks; }
    public CommercialMarket getMarket() { return market; }
}