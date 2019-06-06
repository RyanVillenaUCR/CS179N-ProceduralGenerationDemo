#ifndef TILE_HPP
#define TILE_HPP

#include <iostream>
#include <climits>
#include <cstdlib>
#include <string>

#include "coord2d.hpp"

class Tile
{
public:

    enum TileType {
        EMPTY,
        TRAVERSABLE,
        NON_TRAVERSABLE
    };

    Tile() :
        type(TileType::EMPTY),
        distance(0),
        prev(nullptr),
        location(Coord2D(0, 0))
    {}

    Tile(const Tile& other) :
        type(other.type),
        distance(other.distance),
        prev(other.prev),
        location(other.location)
    {}

    Tile& operator =(const Tile& printMe) {

        this->type = printMe.type;
        this->distance = printMe.distance;
        this->prev = printMe.prev;
        this->location = printMe.location;

        return *this;
    }

    ~Tile() {}

    Tile(TileType type, Coord2D location) :
        type(type), distance(0), prev(nullptr), location(location) {}

    char getChar() const {

        switch(type) {

        case EMPTY:
            return '.';
        case TRAVERSABLE:
            return 't';
        case NON_TRAVERSABLE:
            return 'N';
        default:
            return '?';
        }
    }

    void setType(TileType t) {
        type = t;
    }

    TileType getType() const {

        return type;
    }

    friend std::ostream& operator <<(std::ostream& out, const Tile& printMe) {

//        char distance_buffer[64];
//        itoa(printMe.distance, distance_buffer, 10);

        out << "Type " << printMe.getChar() << ", ";

        if (printMe.distance == UINT_MAX)
            out << "distance = MAX_VALUE, ";
        else
            out << "distance = " << printMe.distance << ", ";

        out << "location (" << printMe.location.first << ", " << printMe.location.second << ")";

        return out;
    }

    void setDistance(unsigned int distance) {

        this->distance = distance;
    }

    unsigned int getDistance() const {

        return distance;
    }

    void setPreviousTile(Tile* prev) {

        this->prev = prev;
    }

    Tile* getPreviousTile() const {

        return prev;
    }

    void setLocation(Coord2D location) {

        this->location.first = location.first;
        this->location.second = location.second;
    }

    Coord2D getLocation() const {

        return location;
    }


private:
    TileType type;
    unsigned int distance;
    Tile* prev;
    Coord2D location;
};

#endif // TILE_HPP
