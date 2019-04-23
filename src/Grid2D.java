//import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Grid2D {
    
    /**
     * @param dimensions X is columns, Y is rows
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
                
                setTile(Tile.EMPTY, thisRow, thisCol);
            }
        }
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
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
    
    public void setTile(Tile t, int row, int col) {
        
        assert 0 <= row && row < ROWS : " Invalid row " + Integer.toString(row);
        assert 0 <= col && col < COLS : " Invalid col " + Integer.toString(col);
        
        grid[row][col] = t;
    }
    
    public char getChar(int row, int col) {
        
        return tileToChar.get(grid[row][col]);
    }
    
    
    private final int ROWS;
    private final int COLS;
    private Tile[][] grid;
    
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
    
    private Map<Character, Tile> charToTile;
    private Map<Tile, Character> tileToChar;
    
}
