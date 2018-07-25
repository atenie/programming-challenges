//
// Created by alexandru on 03.06.2018.
//

#ifndef L7_REPOSITORY_H
#define L7_REPOSITORY_H


#include <vector>
#include <memory>
#include <algorithm>
#include <fstream>
#include "Movie.h"

class Repository {
public:
    // CRUD methods
    void addMovie(std::shared_ptr<Movie> m);
    void addToWatchList(std::shared_ptr<Movie> m);

    std::vector<std::shared_ptr<Movie>> retWList();
    std::vector<std::shared_ptr<Movie>> retMList();
    void SaveToCSV(std::vector<std::shared_ptr<Movie>> someList);//salvare default
    void SaveToHTML(std::vector<std::shared_ptr<Movie>> someList);

    int findMoviePos(std::string Title);
    int findWLPos(std::string Title);
    std::vector<std::shared_ptr<Movie>> getMovie(std::string Genre);
    int getLikes();

    void updMovie(std::shared_ptr<Movie> m, int pos);

    void delMovie(int i);
    void delWListMovie(int i);

    void MovieToWL(int pos);
    std::vector<std::shared_ptr<Movie>> w_List;
protected:
    std::vector<std::shared_ptr<Movie>> m_List;
    std::vector<std::shared_ptr<Movie>> found;
};



#endif //L7_REPOSITORY_H
