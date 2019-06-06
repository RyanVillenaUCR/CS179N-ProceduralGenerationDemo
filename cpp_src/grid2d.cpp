#include "grid2d.hpp"
#include <cassert>

void Grid2D::setTypeLine(const Coord2D& point1, const Coord2D& point2,
    Tile::TileType type, bool prioritize) {

    assertBounds(point1);
    assertBounds(point2);

    assert(areOnSameLine(point1, point2));

    // If they're just the same point,
    // just set that one tile
    if (point1 == point2) {

        Tile& t = getTile(point1.first, point1.second);

        if (prioritize || t.getType() == Tile::TileType::EMPTY)
            t.setType(type);

        return;
    }

    // If on the same row
    if (areSameRow(point1, point2)) {

        // Iterate through from least x to greatest x,
        // whichever is which
        unsigned int smaller_x = (point1.first < point2.first ? point1.first : point2.first);
        unsigned int bigger_x  = (point1.first > point2.first ? point1.first : point2.first);

        for (unsigned int i = smaller_x; i <= bigger_x; i++) {

            Tile& thisTile = getTile(i, point1.second);

            if (prioritize || thisTile.getType() == Tile::TileType::EMPTY)
                thisTile.setType(type);
        }
    }

    // Else, they must be on same col
    else {

        assert(areSameCol(point1, point2));

        // Iterate through from least y to greatest y,
        // whichever is which
        unsigned int smaller_y = (point1.second < point2.second ? point1.second : point2.second);
        unsigned int bigger_y  = (point1.second > point2.second ? point1.second : point2.second);

        for (unsigned int i = 0; i <= bigger_y; i++) {

            Tile& thisTile = getTile(point1.first, i);

            if (prioritize || thisTile.getType() == Tile::TileType::EMPTY)
                thisTile.setType(type);
        }
    }
}

void Grid2D::setTypeRect(const Coord2D& lowerLeft, const Coord2D& upperRight,
    Tile::TileType type, bool prioritize) {

    // Error checking
    assertBounds(lowerLeft);
    assertBounds(upperRight);

    assert(lowerLeft.first  <= upperRight.first);
    assert(lowerLeft.second <= upperRight.second);



    // If it's actually just a line,
    // just call the helper function
    if (areOnSameLine(lowerLeft, upperRight)) {

        setTypeLine(lowerLeft, upperRight, type, prioritize);
        return;
    }

    // If we're here, then we're marking a non-line rectangle,
    // and the arguments were provided in correct order
    for (unsigned int thisY = lowerLeft.second; thisY <= upperRight.second; thisY++) {

        // Mark row by row

        Coord2D thisRowLeft (lowerLeft.first,  thisY);
        Coord2D thisRowRight(upperRight.first, thisY);

        setTypeLine(thisRowLeft, thisRowRight, type, prioritize);
    }
}

void Grid2D::setTypeLine(const Coord2D& point1, const Coord2D& point2,
    Tile::TileType type, bool prioritize,
    size_t layers) {

    assert(areOnSameLine(point1, point2));

    for (size_t thisLayer = 0; thisLayer <= layers; thisLayer++) {

        // Two cases - either we should draw a row (horizontal),
        // or we should draw a column (vertical)

        // Row
        if (areSameRow(point1, point2)) {

            // Do row on top, offset by thisLayer
            Coord2D point1Layered(point1.first, point1.second + thisLayer);
            Coord2D point2Layered(point2.first, point2.second + thisLayer);

            if (checkBounds(point1Layered) && checkBounds(point2Layered))
                setTypeLine(point1Layered, point2Layered, type, prioritize);


            // Do row on bot, offset by thisLayer
            point1Layered = Coord2D(point1.first, point1.second - thisLayer);
            point2Layered = Coord2D(point2.first, point2.second - thisLayer);

            if (checkBounds(point1Layered) && checkBounds(point2Layered))
                setTypeLine(point1Layered, point2Layered, type, prioritize);

        }

        // Column
        else {
            assert(areSameCol(point1, point2));

            // Do col on left, offset by thisLayer
            Coord2D point1Layered(point1.first - thisLayer, point1.second);
            Coord2D point2Layered(point2.first - thisLayer, point2.second);

            if (checkBounds(point1Layered) && checkBounds(point2Layered))
                setTypeLine(point1Layered, point2Layered, type, prioritize);



            // Do col on right, offset by thisLayer
            point1Layered = Coord2D(point1.first + thisLayer, point1.second);
            point2Layered = Coord2D(point2.first + thisLayer, point2.second);

            if (checkBounds(point1Layered) && checkBounds(point2Layered))
                setTypeLine(point1Layered, point2Layered, type, prioritize);

        }
    }
}

