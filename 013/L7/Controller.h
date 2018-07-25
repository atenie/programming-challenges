//
// Created by alexandru on 03.06.2018.
//

#ifndef L7_CONTROLLER_H
#define L7_CONTROLLER_H


#include <iostream>
#include <memory>
#include "Repository.h"

class Controller {
public:
    Controller(Repository* repo);
    void addMovieToDB(std::string Title,std::string Genre, unsigned int Year, unsigned int Likes, std::string Trailer);
    void addMovieToWL(std::shared_ptr<Movie> m);
    void addToWL(std::string Title);
    void readMovies();
    std::vector<std::shared_ptr<Movie>> getMList();
    std::vector<std::shared_ptr<Movie>> getWList();
    void editMovie(std::string Title,std::string Genre, unsigned int Year, unsigned int Likes, std::string Trailer);
    void deleteMovie(std::string Title);
    void deleteWatchlistMovie(std::string Title);
    void HTMLSave(std::vector<std::shared_ptr<Movie>> someList);
    void CSVSave(std::vector<std::shared_ptr<Movie>> someList);
    int Likes();
    int findByName(std::string name);
    std::vector<std::shared_ptr<Movie>> findMovies(std::string Genre);
    Repository* repo;
};

#endif //L7_CONTROLLER_H
