# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/alexandru/clion-2018.1.2/bin/cmake/bin/cmake

# The command to remove a file.
RM = /home/alexandru/clion-2018.1.2/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/alexandru/CLionProjects/L7

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/alexandru/CLionProjects/L7/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/L7.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/L7.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/L7.dir/flags.make

CMakeFiles/L7.dir/main.cpp.o: CMakeFiles/L7.dir/flags.make
CMakeFiles/L7.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/alexandru/CLionProjects/L7/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/L7.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/L7.dir/main.cpp.o -c /home/alexandru/CLionProjects/L7/main.cpp

CMakeFiles/L7.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/L7.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/alexandru/CLionProjects/L7/main.cpp > CMakeFiles/L7.dir/main.cpp.i

CMakeFiles/L7.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/L7.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/alexandru/CLionProjects/L7/main.cpp -o CMakeFiles/L7.dir/main.cpp.s

CMakeFiles/L7.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/L7.dir/main.cpp.o.requires

CMakeFiles/L7.dir/main.cpp.o.provides: CMakeFiles/L7.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/L7.dir/build.make CMakeFiles/L7.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/L7.dir/main.cpp.o.provides

CMakeFiles/L7.dir/main.cpp.o.provides.build: CMakeFiles/L7.dir/main.cpp.o


CMakeFiles/L7.dir/Controller.cpp.o: CMakeFiles/L7.dir/flags.make
CMakeFiles/L7.dir/Controller.cpp.o: ../Controller.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/alexandru/CLionProjects/L7/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/L7.dir/Controller.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/L7.dir/Controller.cpp.o -c /home/alexandru/CLionProjects/L7/Controller.cpp

CMakeFiles/L7.dir/Controller.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/L7.dir/Controller.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/alexandru/CLionProjects/L7/Controller.cpp > CMakeFiles/L7.dir/Controller.cpp.i

CMakeFiles/L7.dir/Controller.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/L7.dir/Controller.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/alexandru/CLionProjects/L7/Controller.cpp -o CMakeFiles/L7.dir/Controller.cpp.s

CMakeFiles/L7.dir/Controller.cpp.o.requires:

.PHONY : CMakeFiles/L7.dir/Controller.cpp.o.requires

CMakeFiles/L7.dir/Controller.cpp.o.provides: CMakeFiles/L7.dir/Controller.cpp.o.requires
	$(MAKE) -f CMakeFiles/L7.dir/build.make CMakeFiles/L7.dir/Controller.cpp.o.provides.build
.PHONY : CMakeFiles/L7.dir/Controller.cpp.o.provides

CMakeFiles/L7.dir/Controller.cpp.o.provides.build: CMakeFiles/L7.dir/Controller.cpp.o


CMakeFiles/L7.dir/Repository.cpp.o: CMakeFiles/L7.dir/flags.make
CMakeFiles/L7.dir/Repository.cpp.o: ../Repository.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/alexandru/CLionProjects/L7/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/L7.dir/Repository.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/L7.dir/Repository.cpp.o -c /home/alexandru/CLionProjects/L7/Repository.cpp

CMakeFiles/L7.dir/Repository.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/L7.dir/Repository.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/alexandru/CLionProjects/L7/Repository.cpp > CMakeFiles/L7.dir/Repository.cpp.i

CMakeFiles/L7.dir/Repository.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/L7.dir/Repository.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/alexandru/CLionProjects/L7/Repository.cpp -o CMakeFiles/L7.dir/Repository.cpp.s

CMakeFiles/L7.dir/Repository.cpp.o.requires:

.PHONY : CMakeFiles/L7.dir/Repository.cpp.o.requires

CMakeFiles/L7.dir/Repository.cpp.o.provides: CMakeFiles/L7.dir/Repository.cpp.o.requires
	$(MAKE) -f CMakeFiles/L7.dir/build.make CMakeFiles/L7.dir/Repository.cpp.o.provides.build
.PHONY : CMakeFiles/L7.dir/Repository.cpp.o.provides

CMakeFiles/L7.dir/Repository.cpp.o.provides.build: CMakeFiles/L7.dir/Repository.cpp.o


CMakeFiles/L7.dir/MainWindow.cpp.o: CMakeFiles/L7.dir/flags.make
CMakeFiles/L7.dir/MainWindow.cpp.o: ../MainWindow.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/alexandru/CLionProjects/L7/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/L7.dir/MainWindow.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/L7.dir/MainWindow.cpp.o -c /home/alexandru/CLionProjects/L7/MainWindow.cpp

CMakeFiles/L7.dir/MainWindow.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/L7.dir/MainWindow.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/alexandru/CLionProjects/L7/MainWindow.cpp > CMakeFiles/L7.dir/MainWindow.cpp.i

CMakeFiles/L7.dir/MainWindow.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/L7.dir/MainWindow.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/alexandru/CLionProjects/L7/MainWindow.cpp -o CMakeFiles/L7.dir/MainWindow.cpp.s

CMakeFiles/L7.dir/MainWindow.cpp.o.requires:

.PHONY : CMakeFiles/L7.dir/MainWindow.cpp.o.requires

CMakeFiles/L7.dir/MainWindow.cpp.o.provides: CMakeFiles/L7.dir/MainWindow.cpp.o.requires
	$(MAKE) -f CMakeFiles/L7.dir/build.make CMakeFiles/L7.dir/MainWindow.cpp.o.provides.build
.PHONY : CMakeFiles/L7.dir/MainWindow.cpp.o.provides

CMakeFiles/L7.dir/MainWindow.cpp.o.provides.build: CMakeFiles/L7.dir/MainWindow.cpp.o


CMakeFiles/L7.dir/AddWindow.cpp.o: CMakeFiles/L7.dir/flags.make
CMakeFiles/L7.dir/AddWindow.cpp.o: ../AddWindow.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/alexandru/CLionProjects/L7/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/L7.dir/AddWindow.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/L7.dir/AddWindow.cpp.o -c /home/alexandru/CLionProjects/L7/AddWindow.cpp

CMakeFiles/L7.dir/AddWindow.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/L7.dir/AddWindow.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/alexandru/CLionProjects/L7/AddWindow.cpp > CMakeFiles/L7.dir/AddWindow.cpp.i

CMakeFiles/L7.dir/AddWindow.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/L7.dir/AddWindow.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/alexandru/CLionProjects/L7/AddWindow.cpp -o CMakeFiles/L7.dir/AddWindow.cpp.s

CMakeFiles/L7.dir/AddWindow.cpp.o.requires:

.PHONY : CMakeFiles/L7.dir/AddWindow.cpp.o.requires

CMakeFiles/L7.dir/AddWindow.cpp.o.provides: CMakeFiles/L7.dir/AddWindow.cpp.o.requires
	$(MAKE) -f CMakeFiles/L7.dir/build.make CMakeFiles/L7.dir/AddWindow.cpp.o.provides.build
.PHONY : CMakeFiles/L7.dir/AddWindow.cpp.o.provides

CMakeFiles/L7.dir/AddWindow.cpp.o.provides.build: CMakeFiles/L7.dir/AddWindow.cpp.o


# Object files for target L7
L7_OBJECTS = \
"CMakeFiles/L7.dir/main.cpp.o" \
"CMakeFiles/L7.dir/Controller.cpp.o" \
"CMakeFiles/L7.dir/Repository.cpp.o" \
"CMakeFiles/L7.dir/MainWindow.cpp.o" \
"CMakeFiles/L7.dir/AddWindow.cpp.o"

# External object files for target L7
L7_EXTERNAL_OBJECTS =

L7: CMakeFiles/L7.dir/main.cpp.o
L7: CMakeFiles/L7.dir/Controller.cpp.o
L7: CMakeFiles/L7.dir/Repository.cpp.o
L7: CMakeFiles/L7.dir/MainWindow.cpp.o
L7: CMakeFiles/L7.dir/AddWindow.cpp.o
L7: CMakeFiles/L7.dir/build.make
L7: /usr/lib/x86_64-linux-gnu/libQt5Widgets.so.5.9.5
L7: /usr/lib/x86_64-linux-gnu/libQt5Gui.so.5.9.5
L7: /usr/lib/x86_64-linux-gnu/libQt5Core.so.5.9.5
L7: CMakeFiles/L7.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/alexandru/CLionProjects/L7/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Linking CXX executable L7"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/L7.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/L7.dir/build: L7

.PHONY : CMakeFiles/L7.dir/build

CMakeFiles/L7.dir/requires: CMakeFiles/L7.dir/main.cpp.o.requires
CMakeFiles/L7.dir/requires: CMakeFiles/L7.dir/Controller.cpp.o.requires
CMakeFiles/L7.dir/requires: CMakeFiles/L7.dir/Repository.cpp.o.requires
CMakeFiles/L7.dir/requires: CMakeFiles/L7.dir/MainWindow.cpp.o.requires
CMakeFiles/L7.dir/requires: CMakeFiles/L7.dir/AddWindow.cpp.o.requires

.PHONY : CMakeFiles/L7.dir/requires

CMakeFiles/L7.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/L7.dir/cmake_clean.cmake
.PHONY : CMakeFiles/L7.dir/clean

CMakeFiles/L7.dir/depend:
	cd /home/alexandru/CLionProjects/L7/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/alexandru/CLionProjects/L7 /home/alexandru/CLionProjects/L7 /home/alexandru/CLionProjects/L7/cmake-build-debug /home/alexandru/CLionProjects/L7/cmake-build-debug /home/alexandru/CLionProjects/L7/cmake-build-debug/CMakeFiles/L7.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/L7.dir/depend

