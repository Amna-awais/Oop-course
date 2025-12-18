package lab;

public class CityDemo {
    public static void main(String[] args) {
        // Create city housing system
        CityHousing lahore = new CityHousing();
        
        // Print initial city report
        lahore.printCityReport();
        
        // Test booking
        System.out.println("Booking plot 3-007 in LDA Avenue 1, Block A: " + 
                lahore.bookPlot("LDA Avenue 1", "A", "3-007"));
        
        // Test double booking
        System.out.println("Booking plot 3-007 in LDA Avenue 1, Block A again: " + 
                lahore.bookPlot("LDA Avenue 1", "A", "3-007"));
        
        // Test cancellation
        System.out.println("Canceling plot 3-007 in LDA Avenue 1, Block A: " + 
                lahore.cancelPlot("LDA Avenue 1", "A", "3-007"));
        
        // Print updated street layout
        HousingSociety lda1 = lahore.findSociety("LDA Avenue 1");
        Block blockA = lda1.findBlock("A");
        blockA.printStreetLayout();
        
        // Find first available RES_1_KANAL CornerPlot in LDA Avenue 2
        HousingSociety lda2 = lahore.findSociety("LDA Avenue 2");
        Plot[] res1KanalPlots = lda2.getPlotsByType(PlotType.RES_1_KANAL);
        for (Plot plot : res1KanalPlots) {
            if (plot instanceof CornerPlot && plot.isAvailable()) {
                System.out.println("First available RES_1_KANAL CornerPlot in LDA Avenue 2: " + plot);
                break;
            }
        }
        
        // List first three vacant shops in Block C market of LDA Avenue 1
        Block blockC = lda1.findBlock("C");
        CommercialMarket market = blockC.getMarket();
        Shop[] vacantShops = market.getVacantShops();
        System.out.println("First three vacant shops in Block C market of LDA Avenue 1:");
        for (int i = 0; i < Math.min(3, vacantShops.length); i++) {
            System.out.println(vacantShops[i]);
        }
    }
}