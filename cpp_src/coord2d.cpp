#include "coord2d.hpp"

std::ostream& operator <<(std::ostream& out, const Coord2D& printMe) {

    out << "(" << printMe.first << ", " << printMe.second << ")";
    return out;
}

bool areSameRow(const Coord2D& point1, const Coord2D& point2) {

    return point1.second == point2.second;
}

bool areSameCol(const Coord2D& point1, const Coord2D& point2) {

    return point1.first == point2.first;
}

bool areOnSameLine(const Coord2D& point1, const Coord2D& point2) {

    return areSameRow(point1, point2) || areSameCol(point1, point2);
}
