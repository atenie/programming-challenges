//
// Created by alexandru on 03.06.2018.
//

#include "Controller.h"


Controller::Controller(Repository *repo) {
    this->repo = repo;
}

void Controller::addMovieToDB(std::string Title,std::string Genre, unsigned int Year, unsigned int Likes, std::string Trailer) {
    std::shared_ptr<Movie> m(new Movie(Title, Genre, Year, Likes, Trailer));
    repo->addMovie(std::move(m));
}

void Controller::addMovieToWL(std::shared_ptr<Movie> m) {
    repo->addToWatchList(m);
}

void Controller::readMovies() {
    std::string Title;
    std::string Genre;
    std::string Year;
    std::string Likes;
    unsigned int m_Year;
    unsigned int m_Likes;
    std::string Trailer;
    std::ifstream f("/home/alexandru/CLionProjects/L6/movies.csv");
    if (!f.is_open())
        std::cout<<"ERROR FILE CAN'T BE OPENED";
    while (f.good())
    {
        std::getline(f,Title,',');
        if(Title!="") {
            std::getline(f, Genre, ',');
            std::getline(f, Year, ',');
            std::getline(f, Likes, ',');
            std::getline(f, Trailer, '\n');
            m_Year = std::stoul(Year);
            m_Likes = std::stoul(Likes);
            std::shared_ptr<Movie> m(new Movie(Title, Genre, m_Year, m_Likes, Trailer));
            repo->addMovie(m);
        }
    }
}



void Controller::editMovie(std::string Title, std::string Genre, unsigned int Year, unsigned int Likes, std::string Trailer) {
    std::shared_ptr<Movie> m(new Movie(Title, Genre, Year, Likes, Trailer));
    int pos;
    pos=repo->findMoviePos(Title);
    repo->updMovie(m,pos);
}

std::vector<std::shared_ptr<Movie>> Controller::findMovies(std::string Genre) {
    return repo->getMovie(Genre);
}

void Controller::deleteMovie(std::string Title) {
    int pos;
    pos=repo->findMoviePos(Title);
    if(pos!=-1)
        repo->delMovie(pos);
}

void Controller::deleteWatchlistMovie(std::string Title) {
    int pos=-2;
    pos=repo->findWLPos(Title);
    repo->delWListMovie(pos);
}

int Controller::Likes() {
    return repo->getLikes();
}

void Controller::HTMLSave(std::vector<std::shared_ptr<Movie>> someList) {
    this->repo->SaveToHTML(someList);
}

void Controller::CSVSave(std::vector<std::shared_ptr<Movie>> someList) {
    this->repo->SaveToCSV(someList);
}

std::vector<std::shared_ptr<Movie>> Controller::getMList() {
    return repo->retMList();
}

std::vector<std::shared_ptr<Movie>> Controller::getWList() {
    return repo->retWList();
}

int Controller::findByName(std::string name) {
    return repo->findMoviePos(name);
}

void Controller::addToWL(std::string Title) {
    int pos;
    pos=repo->findMoviePos(std::move(Title));
    repo->MovieToWL(pos);
}
