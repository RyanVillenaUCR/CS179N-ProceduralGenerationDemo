/**
 * Enum used to represent tiles, which can be marked or unmarked.
 * @author Ryan Villena
 *
 */
public enum Tile {
    
    EMPTY,
    TRAVERSABLE,
    NON_TRAVERSABLE;

    Tile() {
        this.marked = false;
    }
    
    public boolean isMarked() {
        return marked;
    }
    
    public void setMark(boolean mark) {
        this.marked = mark;
    }
    
    private boolean marked;
}