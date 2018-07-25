cmake_minimum_required(VERSION 3.10)
project(L7)

set(CMAKE_CXX_STANDARD 14)
find_package(Qt5Widgets REQUIRED)
find_package(Qt5Core REQUIRED)

add_executable(L7 main.cpp Controller.cpp Controller.h Repository.cpp Repository.h MainWindow.cpp MainWindow.h Movie.h AddWindow.cpp AddWindow.h)
qt5_use_modules(L7 Widgets)
