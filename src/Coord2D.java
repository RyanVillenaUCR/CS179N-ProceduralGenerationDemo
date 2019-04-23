
public class Coord2D {

    public Coord2D(int x, int y) {

        this.x = x;
        this.y = y;
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
    
    private int x;
    private int y;
}
