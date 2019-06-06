#ifndef COORD2D_HPP
#define COORD2D_HPP

#include <iostream>
#include <utility>

#define Coord2D std::pair<unsigned int, unsigned int>

//std::ostream& printCoord2D(std::ostream& out, const Coord2D& printMe);
std::ostream& operator <<(std::ostream& out, const Coord2D& printMe);

bool areSameRow(const Coord2D& point1, const Coord2D& point2);
bool areSameCol(const Coord2D& point1, const Coord2D& point2);
bool areOnSameLine(const Coord2D& point1, const Coord2D& point2);


#endif // COORD2D_HPP
