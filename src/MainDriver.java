/**
 * 
 */

/**
 * @author Ryan Villena
 *
 */
public class MainDriver {

    public static void testGrid() {
        
        Coord2D gridDimensions = new Coord2D(7, 13);
        Coord2D testPoint      = new Coord2D(2, 10);
        Coord2D emptyPoint     = new Coord2D(3, 10);
        @SuppressWarnings("unused")
        Coord2D failPoint      = new Coord2D(7, 14);
        
        Grid2D grid = new Grid2D(gridDimensions);
        grid.setTile(Tile.TileType.TRAVERSABLE, testPoint);
        
        System.out.println(grid.toString());
        System.out.println("Tile at " + testPoint.toString()  + ": " + grid.getTile(testPoint) );
        System.out.println("Tile at " + emptyPoint.toString() + ": " + grid.getTile(emptyPoint));
//        System.out.println("Tile at " + failPoint.toString()  + ": " + grid.getTile(failPoint));
        
        // Test marks
        Coord2D markPoint = new Coord2D(5, 5);
        Coord2D unmarkedPoint = new Coord2D(5, 4);
        grid.getTile(markPoint).setMark(true);
        
        System.out.println("Just marked tile " + markPoint + ", should be marked: " + grid.getTile(markPoint));
        System.out.println("Testing unmarked tile " + unmarkedPoint + ", should not be marked: " + grid.getTile(unmarkedPoint));
        System.out.println(grid);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Hello world!");

		testGrid();
	}

}
