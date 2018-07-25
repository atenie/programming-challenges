//
// Created by alexandru on 03.06.2018.
//

#ifndef L7_MAINWINDOW_H
#define L7_MAINWINDOW_H

#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include "Controller.h"
#include "AddWindow.h"
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QTableWidget>
#include <QtWidgets/QLabel>

class MainWindow : public QWidget {
public:
    MainWindow(Controller* con);
    void getData();
private:
    std::vector<std::shared_ptr<Movie>> movies;
    std::vector<std::shared_ptr<Movie>> watchies;
    QTableWidget *movieTable = new QTableWidget;
    QTableWidget *watchTable = new QTableWidget;
    QHBoxLayout* userBar = new QHBoxLayout;
    QLabel* admText= new QLabel("Admin:");
    QPushButton* addMBtn = new QPushButton("Add");
    QPushButton* addMWLBtn = new QPushButton("Add to Watchlist");
    QPushButton* updMBtn = new QPushButton("Update");
    QPushButton* delMBtn = new QPushButton("Delete");
    QHBoxLayout* admBar = new QHBoxLayout;
    QLabel* userText= new QLabel("User:");
    QPushButton* delWLBtn = new QPushButton("Delete in Watchlist");
    QPushButton* getLBtn = new QPushButton("Get likes");
    QPushButton* CSVBtn = new QPushButton("Open CSV");
    QPushButton* HTMLBtn = new QPushButton("Open HTML");

    QVBoxLayout* mainLayout = new QVBoxLayout;
    Controller* con;
private slots:
    void addMovie();
    void openHyperlink(int row, int col);
    void openCSV();
    void openHTML();
    void GetLikes();
    void removeMovie(int row);
    void removeMovieWL(int row);
    void addMovieWL(int row);
    void updateMovie(int row);
};


#endif //L7_MAINWINDOW_H
