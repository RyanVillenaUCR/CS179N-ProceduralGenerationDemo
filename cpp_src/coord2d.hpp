#ifndef COORD2D_HPP
#define COORD2D_HPP

#include <iostream>
#include <utility>

#define Coord2D std::pair<unsigned int, unsigned int>

//std::ostream& printCoord2D(std::ostream& out, const Coord2D& printMe);
std::ostream& operator <<(std::ostream& out, const Coord2D& printMe);


#endif // COORD2D_HPP
