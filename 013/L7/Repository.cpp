//
// Created by alexandru on 03.06.2018.
//

#include <iostream>
#include "Repository.h"

void Repository::addMovie(std::shared_ptr<Movie> m) {
    m_List.push_back(m);
}


void Repository::addToWatchList(std::shared_ptr<Movie> m) {
    w_List.push_back(m);
}

std::vector<std::shared_ptr<Movie>> Repository::retWList() {
    std::vector<std::shared_ptr<Movie>> copy;
    copy.assign(w_List.begin(),w_List.end());
    return copy;
}

std::vector<std::shared_ptr<Movie>> Repository::retMList() {
    std::vector<std::shared_ptr<Movie>> copy;
    copy.assign(m_List.begin(),m_List.end());
    return copy;
}

void Repository::SaveToCSV(std::vector<std::shared_ptr<Movie>> someList) {
    std::ofstream f("/home/alexandru/CLionProjects/L7/mov.csv");
    if(f.is_open()) {
        for (auto it : someList) {
            f << it->getM_Title() << ",";
            f << it->getM_Genre() << ",";
            f << it->getM_Year() << ",";
            f << it->getM_Likes() << ",";
            f << it->getM_Trailer() << std::endl;
        }
    }
    f.close();
}

void Repository::SaveToHTML(std::vector<std::shared_ptr<Movie>> someList) {
    std::ofstream f("/home/alexandru/CLionProjects/L7/mov.html");
    if(f.is_open()) {
        f << "<html>" <<std::endl;
        f << "<body>" <<std::endl;
        f << "<table style=\"width:100%\">" <<std::endl;
        f << "<tr>" <<std::endl;
        f << "<th>Title</th>" << std::endl;
        f << "<th>Genre</th>" << std::endl;
        f << "<th>Year</th>" << std::endl;
        f << "<th>Likes</th>" << std::endl;
        f << "<th>Trailer</th>" << std::endl;
        f << "</tr>" <<std::endl;
        for (auto it : someList) {
            f << "<tr>" <<std::endl;
            f << "<td>" << it->getM_Title() << "</td>" << std::endl;
            f << "<td>" << it->getM_Genre() << "</td>" << std::endl;
            f << "<td>" << it->getM_Year() << "</td>" << std::endl;
            f << "<td>" << it->getM_Likes() << "</td>" << std::endl;
            f << "<td>" << it->getM_Trailer()<< "</td>" << std::endl;
            f << "</tr>" <<std::endl;
        }
        f << "</table>" <<std::endl;
        f << "</body>" <<std::endl;
        f << "</html>" <<std::endl;
    }

    f.close();
}

int Repository::findMoviePos(std::string Title) {
    for (int i = 0; i < m_List.size(); i++) {
        if ( m_List.at(i)->getM_Title()==Title ) {
            return i;
        }
    }
    return -1;
}
//Ditto.
int Repository::findWLPos(std::string Title) {
    for (int i = 0; i < w_List.size(); i++) {
        if ( w_List.at(i)->getM_Title()==Title ) {
            return i;
        }
    }
    return -1;
}

std::vector<std::shared_ptr<Movie>> Repository::getMovie(std::string Genre) {
    if(Genre!="")
        for (int i = 0; i < m_List.size(); i++) {
            if (m_List.at(i)->getM_Genre() == Genre)
                found.push_back(m_List.at(i));
        }
    else
        for (int i = 0; i < m_List.size(); i++) {
            found.push_back(m_List.at(i));
        }
    return found;
}

int Repository::getLikes() {
    int likesSum=0;
    for(auto it : w_List) {
        likesSum+=it->getM_Likes();
    }
    return likesSum;
}

void Repository::updMovie(std::shared_ptr<Movie> m, int pos) {
    if(pos<=m_List.size())
        m_List.at(pos).swap(m);
}

void Repository::delMovie(int i) {
    if(i!=-1) {
        m_List.erase(m_List.begin() + i);
        m_List.shrink_to_fit();
    }
    std::cout<<i<<std::endl; //testing purposes
}

void Repository::delWListMovie(int i) {
    if(i>-1) {
        w_List.at(i)->setM_Likes(w_List.at(i)->getM_Likes()-1); //scadem numarul de like-uri
        w_List.erase(w_List.begin() + i);
        w_List.shrink_to_fit();
    }
    std::cout<<i<<std::endl; //testing purposes
}

void Repository::MovieToWL(int pos) {
    w_List.push_back(m_List[pos]);
}