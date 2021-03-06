#include <iostream>
#include <utility>
#include <cassert>
#include <set>

#include "coord2d.hpp"
#include "grid2d.hpp"
#include "util.hpp"

void testUInts() {

    std::cout << "0 - 1 in unsigned int: " << UINT_NEG_1 << std::endl;
    std::cout << "-1 in unsigned int:    " << static_cast<unsigned int>(-1) << std::endl;
    std::cout << "Does 0 - 1 == -1 ?     " << ( UINT_NEG_1 == static_cast<unsigned int>(-1) ) << std::endl;
    std::cout << "UINT_MAX:              " << UINT_MAX << std::endl;
    std::cout << "UINT_MAX == -1 ?       " << ( UINT_MAX == UINT_NEG_1 ) << std::endl;

    std::cout << "Would UINT_MAX - 3 be negative?" << std::endl
              << "UINT_MAX - 3: " << UINT_MAX - 3 << std::endl
              << "Would be negative as a signed int? " << wouldBeNegative(UINT_MAX - 3) << std::endl
              << std::endl;
}

void testSetOfPoints() {

    using namespace std;

    Coord2D original(3, 4);
    Coord2D duplicate(original);
    Coord2D anotherOne(6, 9);

    if (original == duplicate)
        cout << "pair::operator == uses equivalence" << endl;
    else
        cout << "pair::operator == uses identity" << endl;

    if (original != duplicate || original == anotherOne)
        cout << "one of the operators is broken..." << endl;

    set<Coord2D> set;
    set.insert(original);

    cout << "Set contains original. Contains duplicate? " << (set.find(duplicate) != set.end()) << endl;

    set.insert(duplicate);
    set.insert(anotherOne);

    cout << "Set count with all three elements inserted: " << set.size() << endl;
}

void testGrid() {

    using namespace std;

    Coord2D gridDimensions(7, 13);
    Coord2D testPoint(0, gridDimensions.second - 1);
    Coord2D emptyPoint(3, 10);
    Coord2D failPoint(7, 14);

    Grid2D grid(gridDimensions);
    grid.setTile(Tile::TileType::TRAVERSABLE, testPoint);

    //grid.setTile(Tile::TileType::NON_TRAVERSABLE, failPoint);

    cout << "Grid:" << endl
         << grid << endl
         << endl;

    cout << "Tile at test point  " << testPoint  << ": " << grid.getTile(testPoint) << endl;
    cout << "Tile at empty point " << emptyPoint << ": " << grid.getTile(emptyPoint) << endl
         << endl;

    cout << "Can testPoint " << testPoint << " go up?    " << grid.canGoUp(testPoint) << endl
         << "Can testPoint " << testPoint << " go down?  " << grid.canGoDown(testPoint) << endl
         << "Can testPoint " << testPoint << " go left?  " << grid.canGoLeft(testPoint) << endl
         << "Can testPoint " << testPoint << " go right? " << grid.canGoRight(testPoint) << endl;
}

void testMarkLine() {

    Coord2D gridDimensions(25, 10);
    Grid2D grid(gridDimensions);

    std::cout << "Empty grid:" << std::endl << grid << std::endl << std::endl;

    Coord2D lowbar_left (0, 2);
    Coord2D lowbar_right(gridDimensions.first - 1, lowbar_left.second);

    std::cout << "Marking lower bar..." << std::endl;
    grid.setTypeLine(lowbar_left, lowbar_right, Tile::TileType::TRAVERSABLE, false, 0);
    std::cout << grid << std::endl << std::endl;

    Coord2D vertbar_down(2, 0);
    Coord2D vertbar_up  (vertbar_down.first, gridDimensions.second - 1);

    std::cout << "Marking vert bar..." << std::endl;
    grid.setTypeLine(vertbar_down, vertbar_up, Tile::TileType::TRAVERSABLE, false, 0);
    std::cout << grid << std::endl << std::endl;

}

void testMarkRect() {

    Coord2D gridDimensions(7, 13);
    Grid2D grid(gridDimensions);

    std::cout << "Empty grid:" << std::endl << grid << std::endl << std::endl;

    Coord2D middleBand_lowLeft(0, 3);
    Coord2D middleBand_upRight(gridDimensions.first - 1, 6);

    std::cout << "Making a band in the middle:" << std::endl;
    grid.setTypeRect(middleBand_lowLeft, middleBand_upRight, Tile::TileType::TRAVERSABLE, false);

    std::cout << grid << std::endl << std::endl;
}

int main(/*int argc, char *argv[]*/)
{
    std::cout << "Hello World!" << std::endl << std::endl;

//    testUInts();

//    testSetOfPoints();

//    testGrid();

//    testMarkLine();

    testMarkRect();



    return 0;
}
