TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += \
    ../coord2d.cpp \
    ../grid2d.cpp \
    ../main.cpp \
    ../tile.cpp

HEADERS += \
    ../coord2d.hpp \
    ../Grid2D.hpp \
    ../tile.hpp \
    ../util.hpp
