
public class Coord2D {

    public Coord2D(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Coord2D(Coord2D other) {
        
        this.x = other.x;
        this.y = other.y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        
        return "{" + Integer.toString(x) + ", " + Integer.toString(y) + "}";
    }
    
    public boolean equals(Coord2D other) {
        
        return this.x == other.x && this.y == other.y;
    }
    
    private int x;
    private int y;
}
