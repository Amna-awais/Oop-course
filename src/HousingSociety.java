package lab;

public class HousingSociety {
    private String name;
    private Block[] blocks;
    private int logicalSize;
    
    public HousingSociety(String name) {
        this.name = name;
        this.blocks = new Block[3]; // Initial capacity
        this.logicalSize = 0;
        
        // Preload with default blocks A, B, C
        addBlock(new Block("A"));
        addBlock(new Block("B"));
        addBlock(new Block("C"));
    }

public void addBlock(Block block) {
        if (logicalSize >= blocks.length) {
            // Grow the array
            Block[] newBlocks = new Block[blocks.length * 2];
            System.arraycopy(blocks, 0, newBlocks, 0, blocks.length);
            blocks = newBlocks;
        }
        blocks[logicalSize++] = block;
    }
    
    public Block findBlock(String name) {
        for (int i = 0; i < logicalSize; i++) {
            if (blocks[i].getName().equals(name)) {
                return blocks[i];
            }
        }
   return null;
    }
    
    public boolean bookPlot(String blockName, String plotId) {
        Block block = findBlock(blockName);
        if (block != null) {
            return block.bookPlot(plotId);
        }
        return false;
    }
 public boolean cancelPlot(String blockName, String plotId) {
        Block block = findBlock(blockName);
        if (block != null) {
            return block.cancelPlot(plotId);
        }
        return false;
    }
    
    public Plot[] getPlotsByType(PlotType type) {
        // First pass: count plots of the specified type
        int count = 0;
        for (int i = 0; i < logicalSize; i++) {
            Plot[] blockPlots = blocks[i].getPlotsByType(type);
            count += blockPlots.length;
        }
     // Second pass: allocate and fill
        Plot[] result = new Plot[count];
        int index = 0;
        for (int i = 0; i < logicalSize; i++) {
            Plot[] blockPlots = blocks[i].getPlotsByType(type);
            System.arraycopy(blockPlots, 0, result, index, blockPlots.length);
            index += blockPlots.length;
        }
        
        return result;
    }
    
    public void printSocietyReport() {
        System.out.println("Society: " + name);
        for (int i = 0; i < logicalSize; i++) { 
     blocks[i].printStreetLayout();
            System.out.println();
        }
    }
    
    // Getters
    public String getName() { return name; }
    public Block[] getBlocks() { return blocks; }
    public int getLogicalSize() { return logicalSize; }
}
  