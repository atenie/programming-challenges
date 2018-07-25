//
// Created by alexandru on 03.06.2018.
//

#ifndef L7_MOVIE_H
#define L7_MOVIE_H


#include <string>

class Movie {
private:
    std::string m_Title;
    std::string m_Genre;
    unsigned int m_Year;
    unsigned int m_Likes;
    std::string m_Trailer;
public:
    Movie() : m_Title{""}, m_Genre{""}, m_Year{0}, m_Likes{0}, m_Trailer{""} {}

    Movie(const std::string &m_Title, const std::string &m_Genre, unsigned int m_Year, unsigned int m_Likes,
          const std::string &m_Trailer) {
        this->m_Title = m_Title;
        this->m_Genre = m_Genre;
        this->m_Year = m_Year;
        this->m_Likes = m_Likes;
        this->m_Trailer = m_Trailer;
    }

    const std::string &getM_Title() const { return m_Title; }

    void setM_Title(const std::string &m_Title) {
        std::string tname = m_Title;
        if (tname.size() > 20) {
            tname.reserve(20);
        }
        this->m_Title = tname;
    }

    const std::string &getM_Genre() const { return m_Genre; }

    void setM_Genre(const std::string &m_Genre) {
        std::string tgenre = m_Genre;
        if (tgenre.size() > 20) {
            tgenre.reserve(20);
        }
        this->m_Title = tgenre;
    }

    unsigned int getM_Year() const { return m_Year; }

    void setM_Year(unsigned int m_Year) {
        this->m_Year = m_Year;
    }

    unsigned int getM_Likes() const { return m_Likes; }

    void setM_Likes(unsigned int m_Likes) {
        this->m_Likes = m_Likes;
    }

    const std::string &getM_Trailer() const { return m_Trailer; }

    void setM_Trailer(const std::string &m_Trailer) {
        std::string ttrailer = m_Trailer;
        if (ttrailer.size() > 20) {
            ttrailer.reserve(20);
        }
        this->m_Title = ttrailer;
    }
};


#endif //L7_MOVIE_H
