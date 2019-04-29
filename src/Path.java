import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Path {

    public Path(Grid2D grid) {
        
        this.grid = grid;
        joints = new ArrayList<Coord2D>();
    }
    
    public Path(Grid2D grid, Coord2D point1, Coord2D point2) {
        
        this.grid = grid;
        this.joints = new ArrayList<Coord2D>();
        
        populateBestPath(point1, point2);
    }
    
    public Path(Grid2D grid, List<Coord2D> joints) {
        
        this.grid = grid;
        this.joints = new ArrayList<Coord2D>(joints);
    }
    
    public boolean areCompatibleJoints(Coord2D joint1, Coord2D joint2) {
        
        return joint1.getX() == joint2.getX() || joint1.getY() == joint2.getY();
    }
    
    /**
     * Append a joint to this path if it's compatible.
     * For more information, see the other overload for this function,
     * addJoint(Coord2D, int).
     * @param newJoint Joint to be added
     * @return True if this joint was compatible and added successfully, false otherwise
     */
    public boolean addJoint(Coord2D newJoint) {
        
        if (joints.isEmpty()) {
            
            joints.add(newJoint);
            return true;
        }
        
        else {
            
            return addJoint(newJoint, joints.size());
        }   
    }
    
    /**
     * Add a joint to this path at the specified index.
     * Joints are required to be compatible,
     * i.e. they lie on the same line as their adjacent joint.
     * If you try to use this function and add a joint which isn't compatible to its neighbors,
     * this function returns false and does NOT add the joint.
     * Else, it adds the joint to this path and returns true.
     * Don't worry if this Path isn't yet complete (i.e. doesn't have 2 or more points);
     * you can add joints with this method and still return true safely.
     * @param newJoint Joint to be added
     * @param index Index in this list of joints
     * @return True if this joint was compatible and added successfully, false otherwise
     */
    public boolean addJoint(Coord2D newJoint, int index) {
        
        joints.add(index, newJoint);
        

        ListIterator<Coord2D> it = joints.listIterator(index);
        
        // Check compatibility with joint before, if it exists
        if (it.hasPrevious()) {
            
            Coord2D left_neighbor = it.previous();
            
            if (!areCompatibleJoints(left_neighbor, newJoint)) {
                
                joints.remove(index);
                return false;
            }
            
            // "Reset" iterator
            it.next();
        }
        
        // Check compatibility with joint next, if it exists
        if (it.hasNext()) {
            
            Coord2D right_neighbor = it.next();
            
            if (!areCompatibleJoints(newJoint, right_neighbor)) {
                
                joints.remove(index);
                return false;
            }
            // no need to reset iterator here
        }
        
        // We've checked its compatibility with both neighbors,
        // so nothing else to do but return true
        return true;
        
    }
    
    /**
     * Sets the type of tiles on this path.
     * Should be used to either set a path as traversable,
     * or to "erase" by setting them to empty (or something else!).
     * Note that you must first set this object's path by giving it 2 or more joints,
     * otherwise you're trying to draw an ill-defined path
     * and I'm going to abort your program.
     * @param type Type that all tiles on this path should be set to
     */
    public void setPathType(Tile.TileType type) {
        
        assert joints.size() >= 2 : " Not enough joints in this path";
        
        Coord2D firstJoint = joints.get(0);
        ListIterator<Coord2D> it = joints.listIterator();
        
        while (it.hasNext()) {
            
            Coord2D secondJoint = it.next();
            grid.setTypeLine(firstJoint, secondJoint, type);            
            
            // Slide first joint
            firstJoint = secondJoint;
        }
    }
    
    /**
     * Populates this Path's "joints" list with the best path between point1 and point2.
     * This is accomplished by implementing Djikstra's algorithm.
     * This Path's grid and joints MUST be set before this method is called.
     * @param src The coordinate that the path should start from
     * @param dest The coordinate that the path should lead to
     */
    private void populateBestPath(Coord2D src, Coord2D dest) {
        
//        Grid2D tempGrid = getDijkstraGrid(this.grid); // generates copy, maintaining types
        Grid2D tempGrid = new Grid2D(this.grid);
        
        Tile srcTile = tempGrid.getTile(src);
        srcTile.setDistance(0);
        
        // Keep track of "seen" tiles
        Set<Tile> seen = new HashSet<Tile>();
        seen.add(srcTile);
        
        
    }
    
    
    
    private Grid2D grid;
    private List<Coord2D> joints;
}
