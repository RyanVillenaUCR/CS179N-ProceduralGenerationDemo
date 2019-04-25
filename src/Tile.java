/**
 * Enum used to represent tiles, which can be marked or unmarked.
 * @author Ryan Villena
 *
 */
public class Tile {
    
    public enum TileType {
        EMPTY,
        TRAVERSABLE,
        NON_TRAVERSABLE
    }

    Tile() {
        this.marked = false;
        this.type = TileType.EMPTY;
    }

    Tile(TileType type) {
        
        this.marked = false;
        this.type = type;
    }
    
    Tile(TileType type, boolean mark) {
        
        this.marked = mark;
        this.type = type;
    }
    
    Tile(Tile t) {
        this.marked = t.marked;
        this.type = t.type;
    }
    
    public char getChar() {
        
        switch (type) {
            
            case EMPTY:
                return '.';
            case TRAVERSABLE:
                return 't';
            case NON_TRAVERSABLE:
                return 'N';
            default:
                return '?';
        }
    }
    
    public boolean isMarked() {
        return marked;
    }
    
    public void setMark(boolean mark) {
        this.marked = mark;
    }
    
    public TileType getType() {
        
        return type;
    }
    
    @Override
    public String toString() {
        
        return TileType.class.getSimpleName() + " " + this.type.toString() + ", "
                + (marked ? "" : "not ") + "marked";
    }
    
    private boolean marked;
    private TileType type;
}