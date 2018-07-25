//
// Created by alexandru on 04.06.2018.
//

#include <QtWidgets/QMessageBox>
#include "AddWindow.h"


void AddWindow::closeWindow() {
    this->close();
}

AddWindow::AddWindow(Controller *con, QTableWidget *movieTable) : QDialog() {
    setWindowTitle("Add movie");
    this->con = con;
    this->movieTable = movieTable;
    mTitle->setPlaceholderText(QString("Title"));
    mGenre->setPlaceholderText(QString("Genre"));
    mYear->setPlaceholderText(QString("Year"));
    mLikes->setPlaceholderText(QString("Likes"));
    mTrailer->setPlaceholderText(QString("Trailer"));

    mainLayout->addWidget(mTitle);
    mainLayout->addWidget(mGenre);
    mainLayout->addWidget(mYear);
    mainLayout->addWidget(mLikes);
    mainLayout->addWidget(mTrailer);

    btnLayout->addWidget(okBtn);
    btnLayout->addWidget(cancelBtn);
    mainLayout->addLayout(btnLayout);
    setLayout(mainLayout);
    connect(cancelBtn, &QPushButton::clicked, this, &AddWindow::closeWindow);
    connect(okBtn, &QPushButton::clicked, this, &AddWindow::addMov);

}

void AddWindow::addMov() {
    if(con->findByName(mTitle->text().toStdString())==-1){
        con->addMovieToDB(mTitle->text().toStdString(),mGenre->text().toStdString(),static_cast<unsigned int>(mYear->text().toInt()),static_cast<unsigned int>(mLikes->text().toInt()),mTrailer->text().toStdString());
        closeWindow();
    }
    else{
        QMessageBox::critical(nullptr, "ERROR", "Already exists");
        closeWindow();
    }
}

UpdWindow::UpdWindow(Controller *con, QTableWidget *movieTable) {
    setWindowTitle("Update movie");
    this->con = con;
    this->movieTable = movieTable;
    mTitle->setPlaceholderText(QString("Title"));
    mGenre->setPlaceholderText(QString("Genre"));
    mYear->setPlaceholderText(QString("Year"));
    mLikes->setPlaceholderText(QString("Likes"));
    mTrailer->setPlaceholderText(QString("Trailer"));

    mainLayout->addWidget(mTitle);
    mainLayout->addWidget(mGenre);
    mainLayout->addWidget(mYear);
    mainLayout->addWidget(mLikes);
    mainLayout->addWidget(mTrailer);

    btnLayout->addWidget(okBtn);
    btnLayout->addWidget(cancelBtn);
    mainLayout->addLayout(btnLayout);
    setLayout(mainLayout);
    connect(cancelBtn, &QPushButton::clicked, this, &UpdWindow::closeWindow);
    connect(okBtn, &QPushButton::clicked, this, &UpdWindow::updMov);
}

void UpdWindow::updMov() {
    if(con->findByName(mTitle->text().toStdString())!=-1){
        con->editMovie(mTitle->text().toStdString(),mGenre->text().toStdString(),static_cast<unsigned int>(mYear->text().toInt()),static_cast<unsigned int>(mLikes->text().toInt()),mTrailer->text().toStdString());
        closeWindow();
    }
    else{
        QMessageBox::critical(nullptr, "ERROR", "Doesn't exist");
        closeWindow();
    }
}


void UpdWindow::closeWindow() {
    this->close();
}