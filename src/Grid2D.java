//import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Grid of Tile objects which can be accessed, changed, and printed.
 * @author Ryan Villena
 *
 */
public class Grid2D {
    
    /**
     * Constructs new Grid2D and initializes all tiles to Tile.EMPTY
     * @param dimensions X is horizontal, Y is vertical
     */
    public Grid2D(Coord2D dimensions) {
        
        assert dimensions.getX() >= 1 : " Invalid dimension " + dimensions.toString();
        assert dimensions.getY() >= 1 : " Invalid dimension " + dimensions.toString();
        
        ROWS = dimensions.getY();
        COLS = dimensions.getX();
        
        initMaps();
        
        grid = new Tile[ROWS][COLS];
        
        for (int thisRow = 0; thisRow < ROWS; thisRow++) {
            for (int thisCol = 0; thisCol < COLS; thisCol++) {
                
                setTile(Tile.EMPTY, new Coord2D(thisCol, thisRow));
            }
        }
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder((ROWS + 2) * (COLS + 2));
        
        // Top row border
        sb.append('*');
        for (int i = 0; i < COLS; i++)
            sb.append('-');
        sb.append('*');
        sb.append('\n');
        
        // Actual grid
        for (int thisRow = 0; thisRow < ROWS; thisRow++) {
            
            for (int thisCol = 0; thisCol < COLS; thisCol++) {
                
                // Left border
                if (thisCol == 0)
                    sb.append('|');
                
                sb.append(tileToChar.get(grid[thisRow][thisCol]));
                
                // Right border
                if (thisCol == COLS - 1)
                    sb.append('|');
            }
            
            sb.append('\n');
        }
        
        
        // Bottom row border
        sb.append('*');
        for (int i = 0; i < COLS; i++)
            sb.append('-');
        sb.append('*');
        sb.append('\n');
        
        
        
        return sb.toString();
    }
    
    /**
     * 
     * @param t Type of tile to be set
     * @param location Desired location
     */
    public void setTile(Tile t, Coord2D location) {
        
        assertBounds(location);
        
        grid[location.getY()][location.getX()] = t;
    }
    
    public Tile getTile(Coord2D location) {
        
        assertBounds(location);
        
        return grid[location.getY()][location.getX()];
    }
    
    public void assertBounds(Coord2D location) {
        
        assert checkBounds(location) : " Invalid coordinate " + location.toString();
    }
    
    public boolean checkBounds(Coord2D location) {
        
        int x = location.getX();
        int y = location.getY();
        
        // Make sure they aren't negative
        if (x < 0 || y < 0) return false;
        
        return x < COLS && y < ROWS;
    }
    
    public char getChar(Coord2D location) {
        
        return tileToChar.get(grid[location.getY()][location.getX()]);
    }

    public boolean canGoUp(Coord2D location) {
        
        return location.getY() > 0;
    }
    
    public boolean canGoDown(Coord2D location) {
        
        return location.getY() < ROWS - 1;
    }
    
    public boolean canGoLeft(Coord2D location) {
        
        return location.getX() > 0;
    }
    
    public boolean canGoRight(Coord2D location) {
        
        return location.getX() < COLS - 1;
    }
    
    
    private final int ROWS;
    private final int COLS;
    private Tile[][] grid;
    
    private Map<Character, Tile> charToTile;
    private Map<Tile, Character> tileToChar;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void initMaps() {
        
//        charToTile = new EnumMap(Character.class);
//        tileToChar = new EnumMap(Tile.class);
        
        charToTile = new HashMap();
        tileToChar = new HashMap();
        
        charToTile.put('.', Tile.EMPTY);
        charToTile.put('t', Tile.TRAVERSABLE);
        charToTile.put('N', Tile.NON_TRAVERSABLE);
        
        tileToChar.put(Tile.EMPTY, '.');
        tileToChar.put(Tile.TRAVERSABLE, 't');
        tileToChar.put(Tile.NON_TRAVERSABLE, 'N');
    }
    

    
}
