package lab;

public class CommercialMarket extends Commercial {
    private Shop[] shops;
    private int logicalSize;
    
    public CommercialMarket(String id, int shopCount) {
        super(id, 0); // Market itself doesn't have a price
        this.shops = new Shop[shopCount];
        this.logicalSize = 0;
        
        // Initialize shops
        for (int i = 0; i < shopCount; i++) {
            String shopId = id + "-S" + String.format("%03d", i + 1);
            shops[i] = new Shop(shopId, PlotType.COMM_SHOP.getBasePrice());
            logicalSize++;
        }
    }
    
    public Shop[] getVacantShops() {
        // First pass: count vacant shops
        int count = 0;
        for (int i = 0; i < logicalSize; i++) {
            if (shops[i].isAvailable()) {
          count++;
            }
        }
        
        // Second pass: allocate and fill
        Shop[] result = new Shop[count];
        int index = 0;
        for (int i = 0; i < logicalSize; i++) {
            if (shops[i].isAvailable()) {
                result[index++] = shops[i];
            }
        }
        
        return result;
    } 
    // Getters
    public Shop[] getShops() { return shops; }
    public int getLogicalSize() { return logicalSize; }
    
    @Override
    public String toString() {
        return String.format("CommercialMarket %s (%d shops, %d vacant)",
                id, logicalSize, getVacantShops().length);
    }
}
