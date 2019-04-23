/**
 * 
 */

/**
 * @author Ryan Villena
 *
 */
public class MainDriver {

    public static void testEmptyGrid() {
        
        Grid2D grid = new Grid2D(new Coord2D(7, 13));
        
        grid.setTile(Tile.TRAVERSABLE, 10, 2);
        
        System.out.println(grid.toString());
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Hello world!");

		testEmptyGrid();
	}

}
