#include "coord2d.hpp"

std::ostream& operator <<(std::ostream& out, const Coord2D& printMe) {

    out << "(" << printMe.first << ", " << printMe.second << ")";
    return out;
}
