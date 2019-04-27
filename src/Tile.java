/**
 * Class used to represent tiles, which can be marked or unmarked.
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
        this.distance = Integer.MAX_VALUE;
    }

    Tile(TileType type) {
        
        this.marked = false;
        this.type = type;
        this.distance = Integer.MAX_VALUE;
    }
    
    Tile(TileType type, int distance) {
        
        this.marked = false;
        this.type = type;
        this.distance = distance;
    }
    
    Tile(TileType type, boolean mark) {
        
        this.marked = mark;
        this.type = type;
        this.distance = Integer.MAX_VALUE;
    }
    
    Tile(Tile t) {
        this.marked = t.marked;
        this.type = t.type;
        this.distance = Integer.MAX_VALUE;
    }
    
    public char getChar() {
        
        if (isMarked())
            return '*';
        
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
    
    public void setType(TileType t) {
        
        this.type = t;
    }
    
    public TileType getType() {
        
        return type;
    }
    
    @Override
    public String toString() {
        
        return TileType.class.getSimpleName() + " " + this.type.toString() + ", "
                + (marked ? "" : "not ") + "marked, "
                + "distance = " + (distance == Integer.MAX_VALUE ? "MAX_VALUE" : distance);
    }
    
    public void setDistance(int distance) {
        
        this.distance = distance;
    }
    
    public int getDistance() {
        
        return distance;
    }
    
    private boolean marked;
    private TileType type;
    private int distance;
}