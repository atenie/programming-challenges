//
// Created by alexandru on 03.06.2018.
//

#include <QtWidgets/QHeaderView>
#include <QtGui/QDesktopServices>
#include <QtCore/QUrl>
#include <QtWidgets/QMessageBox>
#include "MainWindow.h"

void MainWindow::getData() {
    movies=con->getMList();
    watchies=con->getWList();
    movieTable->setRowCount(0);
    for (int i = 0; i < movies.size(); i++){
        movieTable->insertRow(movieTable->rowCount());
        movieTable->setItem(movieTable->rowCount() - 1, 0, new QTableWidgetItem(QString::fromStdString(movies[i]->getM_Title())));
        movieTable->setItem(movieTable->rowCount() - 1, 1, new QTableWidgetItem(QString::fromStdString(movies[i]->getM_Genre())));
        movieTable->setItem(movieTable->rowCount() - 1, 2, new QTableWidgetItem(QString::number(movies[i]->getM_Year())));
        movieTable->setItem(movieTable->rowCount() - 1, 3, new QTableWidgetItem(QString::number(movies[i]->getM_Likes())));
        movieTable->setItem(movieTable->rowCount() - 1, 4, new QTableWidgetItem(QString::fromStdString(movies[i]->getM_Trailer())));
    }
    watchTable->setRowCount(0);
    for (int i = 0; i < watchies.size(); i++){
        watchTable->insertRow(watchTable->rowCount());
        watchTable->setItem(watchTable->rowCount() - 1, 0, new QTableWidgetItem(QString::fromStdString(watchies[i]->getM_Title())));
        watchTable->setItem(watchTable->rowCount() - 1, 1, new QTableWidgetItem(QString::fromStdString(watchies[i]->getM_Genre())));
        watchTable->setItem(watchTable->rowCount() - 1, 2, new QTableWidgetItem(QString::number(watchies[i]->getM_Year())));
        watchTable->setItem(watchTable->rowCount() - 1, 3, new QTableWidgetItem(QString::number(watchies[i]->getM_Likes())));
        watchTable->setItem(watchTable->rowCount() - 1, 4, new QTableWidgetItem(QString::fromStdString(watchies[i]->getM_Trailer())));
    }
}

MainWindow::MainWindow(Controller *con) : QWidget() {
    this->con = con;

    movieTable->setSelectionBehavior(QAbstractItemView::SelectRows);
    movieTable->setShowGrid(false);
    movieTable->setColumnCount(5);
    movieTable->setSizePolicy(QSizePolicy::Expanding, QSizePolicy::Expanding);
    movieTable->setHorizontalHeaderLabels(QString("Title;Genre;Year;Likes;Trailer").split(";"));
    movieTable->horizontalHeader()->setSectionResizeMode(QHeaderView::Stretch);
    mainLayout->addWidget(movieTable);

    admText->setAlignment(Qt::AlignLeft);
    userBar->addWidget(admText);
    userBar->addWidget(addMBtn);
    userBar->addWidget(addMWLBtn);
    userBar->addWidget(updMBtn);
    userBar->addWidget(delMBtn);
    mainLayout->addLayout(userBar);

    watchTable->setSelectionBehavior(QAbstractItemView::SelectRows);
    watchTable->setShowGrid(false);
    watchTable->setColumnCount(5);
    watchTable->setSizePolicy(QSizePolicy::Expanding, QSizePolicy::Expanding);
    watchTable->setHorizontalHeaderLabels(QString("Title;Genre;Year;Likes;Trailer").split(";"));
    watchTable->horizontalHeader()->setSectionResizeMode(QHeaderView::Stretch);
    mainLayout->addWidget(watchTable);

    userText->setAlignment(Qt::AlignLeft);
    admBar->addWidget(userText);
    admBar->addWidget(delWLBtn);
    admBar->addWidget(getLBtn);
    admBar->addWidget(CSVBtn);
    admBar->addWidget(HTMLBtn);
    mainLayout->addLayout(admBar);

    setLayout(mainLayout);
    connect(movieTable, &QTableWidget::cellDoubleClicked, this, &MainWindow::openHyperlink);
    connect(CSVBtn, &QPushButton::clicked, this, &MainWindow::openCSV);
    connect(HTMLBtn, &QPushButton::clicked, this, &MainWindow::openHTML);
    connect(addMBtn, &QPushButton::clicked, this, &MainWindow::addMovie);
    connect(addMWLBtn, &QPushButton::clicked, this, &MainWindow::addMovieWL);
    connect(getLBtn,&QPushButton::clicked, this, &MainWindow::GetLikes );
    connect(delMBtn,&QPushButton::clicked, this, &MainWindow::removeMovie );
    connect(delWLBtn,&QPushButton::clicked, this, &MainWindow::removeMovieWL );
    connect(updMBtn,&QPushButton::clicked, this, &MainWindow::updateMovie );
    getData();
}

void MainWindow::openHyperlink(int row, int col) {
    QTableWidgetItem* myLink;
    if(col==4) {
        myLink=movieTable->item(row,col);
        QUrl ActualLink;
        QString something = myLink->text();
        ActualLink = something;
        QDesktopServices::openUrl(ActualLink);
    }
}

void MainWindow::openCSV() {
    con->CSVSave(watchies);
    system("kate /home/alexandru/CLionProjects/L7/mov.csv");
}

void MainWindow::openHTML() {
    con->HTMLSave(watchies);
    system("palemoon /home/alexandru/CLionProjects/L7/mov.html");
}

void MainWindow::GetLikes() {
    int n;
    QString likes;
    n=con->repo->getLikes();
    likes=QString::number(n);
    QMessageBox::information(nullptr, "Number of Likes", likes);
}

void MainWindow::removeMovie(int row) {
    if(!movieTable->selectedItems().empty()){
        int index;
        QItemSelectionModel *select = movieTable->selectionModel();
        select->hasSelection();//check if has selection
        select->selectedRows();
        index = movieTable->currentRow();
        con->repo->delMovie(index);
        getData();
    }
}

void MainWindow::removeMovieWL(int row) {
    if(!watchTable->selectedItems().empty()){
        int index;
        QItemSelectionModel *select = watchTable->selectionModel();
        select->hasSelection();//check if has selection
        select->selectedRows();
        index = watchTable->currentRow();
        con->repo->delWListMovie(index);
        getData();
    }
}

void MainWindow::addMovieWL(int row) {
    if(!movieTable->selectedItems().empty()){
        int index;
        QItemSelectionModel *select = movieTable->selectionModel();
        select->hasSelection();//check if has selection
        select->selectedRows();
        index = movieTable->currentRow();
        con->repo->MovieToWL(index);
        getData();
    }
}


void MainWindow::addMovie() {
    AddWindow *addMovie = new AddWindow(con, movieTable);
    addMovie->setModal(true);
    addMovie->exec();
    getData();
    delete addMovie;
}

void MainWindow::updateMovie(int row) {
    UpdWindow *updMovie = new UpdWindow(con, movieTable);
    updMovie->setModal(true);
    updMovie->exec();
    getData();
    delete updMovie;
}
