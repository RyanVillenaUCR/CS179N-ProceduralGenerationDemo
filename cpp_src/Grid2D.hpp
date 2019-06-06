#ifndef GRID2D_HPP
#define GRID2D_HPP

#include <cassert>
#include <iostream>
#include <string>

#include "tile.hpp"
#include "coord2d.hpp"
#include "util.hpp"

class Grid2D
{
public:

    Grid2D(const Coord2D& dimensions) : grid_dimensions(dimensions) {

        grid = new Tile*[dimensions.first];

        for (unsigned int x = 0;
             x < grid_dimensions.first;
             x++) {

            grid[x] = new Tile[grid_dimensions.second];

            for (unsigned int y = 0;
                 y < grid_dimensions.second;
                 y++) {

                grid[x][y] = Tile(Tile::TileType::EMPTY, Coord2D(x, y));
            }
        }
    }

    Grid2D(const Grid2D& other) : grid_dimensions(other.grid_dimensions) {

        grid = new Tile*[grid_dimensions.first];

        for (unsigned int x = 0;
             x < grid_dimensions.first;
             x++) {

            grid[x] = new Tile[grid_dimensions.second];

            for (unsigned int y = 0;
                 y < grid_dimensions.second;
                 y++) {

                grid[x][y] = Tile(other.getTile(x, y));
            }
        }
    }

    Grid2D& operator =(const Grid2D& other) {

        this->grid_dimensions = other.grid_dimensions;

        for (unsigned int x = 0;
             x < grid_dimensions.first;
             x++) {

            grid[x] = new Tile[grid_dimensions.second];

            for (unsigned int y = 0;
                 y < grid_dimensions.second;
                 y++) {

                grid[x][y] = Tile(other.getTile(x, y));
            }
        }

        return *this;
    }

    ~Grid2D() {

        for (unsigned int x = 0; x < grid_dimensions.first; x++) {

            delete [] grid[x];
        }

        delete [] grid;
    }

    void setTile(Tile::TileType type, const Coord2D& location) {

        assertBounds(location);

        grid[location.first][location.second].setType(type);
        grid[location.first][location.second].setLocation(location);
    }

    Tile& getTile(const Coord2D& location) const {

        assertBounds(location);

        return grid[location.first][location.second];
    }

    Tile& getTile(unsigned int x, unsigned int y) const {

        Coord2D c(x, y);
        return getTile(c);
    }

    friend std::ostream& operator <<(std::ostream& out, const Grid2D& printMe) {

        out << '*';
        for (unsigned int x = 0; x < printMe.grid_dimensions.first; x++)
            out << '-';
        out << '*';
        out << std::endl;

        for (unsigned int y = printMe.grid_dimensions.second - 1;
             y != static_cast<unsigned int>(0) - static_cast<unsigned int>(1);
             y--) {

            for (unsigned int x = 0; x < printMe.grid_dimensions.first; x++) {

                if (x == 0) out << '|';

                Tile& thisTile = printMe.getTile(x, y);
                out << thisTile.getChar();

                if (x == printMe.grid_dimensions.first - 1) out << '|';

                //std::cerr << "Printing coordinate (" << x << ", " << y << ")" << std::endl;
            }

            out << std::endl;
        }

        out << '*';
        for (unsigned int x = 0; x < printMe.grid_dimensions.first; x++)
            out << '-';
        out << '*';

        return out;
    }

    void assertBounds(const Coord2D& location) const {

        assert(checkBounds(location));
    }

    bool checkBounds(Coord2D location) const {

        return location.first < grid_dimensions.first
                && location.second < grid_dimensions.second;
    }

    Coord2D getGridDimensions() const {

        return grid_dimensions;
    }

    size_t size() const {

        return grid_dimensions.first * grid_dimensions.second;
    }

    char getChar(const Coord2D& location) const {

        return getTile(location).getChar();
    }

    bool canGoUp(const Coord2D& fromHere) const {

        return fromHere.second + 1 < grid_dimensions.second;
    }

    bool canGoDown(const Coord2D& fromHere) const {

        return fromHere.second - 1 != UINT_NEG_1;
    }

    bool canGoLeft(const Coord2D& fromHere) const {

        return fromHere.first - 1 != UINT_NEG_1;
    }

    bool canGoRight(const Coord2D& fromHere) const {

        return fromHere.first + 1 < grid_dimensions.first;
    }

    Tile& getUp(const Coord2D& fromHere) const {

        assert(canGoUp(fromHere));

        return getTile(fromHere.first, fromHere.second + 1);
    }

    Tile& getDown(const Coord2D& fromHere) const {

        assert(canGoDown(fromHere));

        return getTile(fromHere.first, fromHere.second - 1);
    }

    Tile& getLeft(const Coord2D& fromHere) {

        assert(canGoLeft(fromHere));

        return getTile(fromHere.first - 1, fromHere.second);
    }

    Tile& getRight(const Coord2D& fromHere) {

        assert(canGoRight(fromHere));

        return getTile(fromHere.first + 1, fromHere.second);
    }

private:

    Coord2D grid_dimensions;

protected:
    Tile** grid;

};

#endif // GRID2D_HPP
