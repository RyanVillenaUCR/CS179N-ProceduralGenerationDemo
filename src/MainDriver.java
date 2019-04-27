/**
 * Project to demonstrate procedural generation on a 2D grid.
 */

/**
 * Driver class to run tests/demos on procedural generation,
 * or even just user tests.
 * @author Ryan Villena
 *
 */
public class MainDriver {

    public static void testGrid() {
        
        Coord2D gridDimensions = new Coord2D(7, 13);
        Coord2D testPoint      = new Coord2D(0, gridDimensions.getY() - 1);
        Coord2D emptyPoint     = new Coord2D(3, 10);
        @SuppressWarnings("unused")
        Coord2D failPoint      = new Coord2D(7, 14);
        
        Grid2D grid = new Grid2D(gridDimensions);
        grid.setTile(Tile.TileType.TRAVERSABLE, testPoint);
        
        // Test tile types
        System.out.println(grid.toString());
        System.out.println("Tile at " + testPoint.toString()  + ": " + grid.getTile(testPoint) );
        System.out.println("Tile at " + emptyPoint.toString() + ": " + grid.getTile(emptyPoint));
//        System.out.println("Tile at " + failPoint.toString()  + ": " + grid.getTile(failPoint));
        
        // Test directions
        System.out.println("Can testPoint go up? "   + grid.canGoUp(testPoint));
        System.out.println("Can testPoint go down? " + grid.canGoDown(testPoint));
        System.out.println("Can testPoint go left? " + grid.canGoLeft(testPoint));
        System.out.println("Can testPoint go right? "+ grid.canGoRight(testPoint));
        
        System.out.println("Getting the up of testPoint:" + grid.getUp(testPoint));
        System.out.println("Getting testPoint manually: " + grid.getTile(testPoint));
        
        System.out.println(grid);
        
        // Test marks
//        Coord2D markPoint = new Coord2D(5, 5);
//        Coord2D unmarkedPoint = new Coord2D(5, 4);
//        grid.getTile(markPoint).setMark(true);
//        
//        System.out.println("Just marked tile " + markPoint + ", should be marked: " + grid.getTile(markPoint));
//        System.out.println("Testing unmarked tile " + unmarkedPoint + ", should not be marked: " + grid.getTile(unmarkedPoint));
//        System.out.println(grid);
    }
    
    public static void testMarkRow() {
        
        Coord2D gridDimensions = new Coord2D(7, 13);
        Grid2D grid = new Grid2D(gridDimensions);
        
        System.out.println("Empty grid:\n" + grid);
        
        Coord2D lowbar_left = new Coord2D(0, 2);
        Coord2D lowbar_right = new Coord2D(gridDimensions.getX() - 1, lowbar_left.getY());
        Coord2D vertbar_down = new Coord2D(2, 0);
        Coord2D vertbar_up = new Coord2D(vertbar_down.getX(), gridDimensions.getY() - 1);
        
        System.out.println("Marking lower bar...");
        grid.markLine(lowbar_left, lowbar_right, true);
        System.out.println(grid);
        
        System.out.println("Marking vert bar...");
        grid.markLine(vertbar_down, vertbar_up, true);
        System.out.println(grid);
        
        
    }
    
    public static void testMarkRect() {
        
        Coord2D gridDimensions = new Coord2D(7, 13);
        Grid2D grid = new Grid2D(gridDimensions);
        
        System.out.println("Empty grid:\n" + grid);
        
        Coord2D middleBand_lowleft = new Coord2D(0, 3);
        Coord2D middleBand_upRight = new Coord2D(gridDimensions.getX() - 1, 6);
        
        System.out.println("Marking a band in the middle:");
        grid.markRect(middleBand_lowleft, middleBand_upRight, true);
        
        System.out.println(grid);
    }
    
    public static void testPaths() {
        
        Grid2D grid = new Grid2D(new Coord2D(50, 50));
        
        System.out.println("Empty grid:\n\n" + grid);
        
//        List<Coord2D> pathJoints = new ArrayList<Coord2D>();
////        pathJoints.add(new Coord2D(2, 3));
////        pathJoints.add(new Coord2D(10, 3));
//        pathJoints.add(new Coord2D(10, 1));
//        pathJoints.add(new Coord2D(10, 45));
//        pathJoints.add(new Coord2D(48, 45));
//        pathJoints.add(new Coord2D(48, 2));
//        
//        Path path = new Path(grid, pathJoints);
////        grid.setTypeLine(pathJoints.get(0), pathJoints.get(1), Tile.TileType.TRAVERSABLE);
//        path.setPathType(Tile.TileType.TRAVERSABLE);
//        
//        System.out.println("Populated grid:\n\n" + grid);
        
        Path path = new Path(grid);
        assert path.addJoint(new Coord2D(10, 1));
        assert path.addJoint(new Coord2D(10, 2));
        assert path.addJoint(new Coord2D(30, 2));
        assert path.addJoint(new Coord2D(30, 0));
        
        path.setPathType(Tile.TileType.TRAVERSABLE);
        

        
        Grid2D copy = new Grid2D(grid);
        copy.setTile(Tile.TileType.TRAVERSABLE, new Coord2D(0, 0));
        
        System.out.println("Populated grid:\n\n" + grid);
        System.out.println("Copy:\n\n" + copy);
    }
    
    public static void testMapRegions() {
        
        Coord2D gridDimensions = new Coord2D(50, 50);
        Grid2D grid = new Grid2D(gridDimensions);
        
        System.out.println("Empty grid:\n\n" + grid);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Hello world!");

//		testGrid();
		
//		testMarkRow();
		
//		testMarkRect();
		
		testPaths();
		
//		testMapRegions();
	}

}
