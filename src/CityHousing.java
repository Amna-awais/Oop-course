package lab;

public class CityHousing {
    private HousingSociety[] societies;
    private int logicalSize;
    
    public CityHousing() {
        this.societies = new HousingSociety[2]; // Initial capacity
        this.logicalSize = 0;
        
        // Preload with LDA Avenue 1 and LDA Avenue 2
        addSociety(new HousingSociety("LDA Avenue 1"));
        addSociety(new HousingSociety("LDA Avenue 2"));
    }
    
    public void addSociety(HousingSociety society) {
        if (logicalSize >= societies.length) {
            // Grow the array
            HousingSociety[] newSocieties = new HousingSociety[societies.length * 2];
            System.arraycopy(societies, 0, newSocieties, 0, societies.length);
            societies = newSocieties;
        }
        societies[logicalSize++] = society;
    }
    
    public HousingSociety findSociety(String name) {
        for (int i = 0; i < logicalSize; i++) {
            if (societies[i].getName().equals(name)) {
                return societies[i];
            }
        }
        return null;
    }
    
    public boolean bookPlot(String societyName, String blockName, String plotId) {
        HousingSociety society = findSociety(societyName);
        if (society != null) {
            return society.bookPlot(blockName, plotId);
        }
        return false;
    }
    
    public boolean cancelPlot(String societyName, String blockName, String plotId) {
        HousingSociety society = findSociety(societyName);
        if (society != null) {
            return society.cancelPlot(blockName, plotId);
        }
        return false;
    }
    
    public Plot[] getPlotsByType(PlotType type) {
        // First pass: count plots of the specified type
        int count = 0;
        for (int i = 0; i < logicalSize; i++) {
            Plot[] societyPlots = societies[i].getPlotsByType(type);
            count += societyPlots.length;
        }
        
        // Second pass: allocate and fill
        Plot[] result = new Plot[count];
        int index = 0;
        for (int i = 0; i < logicalSize; i++) {
            Plot[] societyPlots = societies[i].getPlotsByType(type);
            System.arraycopy(societyPlots, 0, result, index, societyPlots.length);
            index += societyPlots.length;
        }
        
        return result;
    }
    
    public void printCityReport() {
        System.out.println("City: Lahore");
        for (int i = 0; i < logicalSize; i++) {
            societies[i].printSocietyReport();
        }
    }
    
    // Getters
    public HousingSociety[] getSocieties() { return societies; }
    public int getLogicalSize() { return logicalSize; }
}