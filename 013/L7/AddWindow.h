//
// Created by alexandru on 04.06.2018.
//

#ifndef L7_ADDWINDOW_H
#define L7_ADDWINDOW_H

#include <QtWidgets/QDialog>
#include <QtWidgets/QTableWidget>
#include <QtWidgets/QLineEdit>
#include<QtWidgets/QPushButton>
#include <QtWidgets/QHBoxLayout>
#include "Controller.h"

class AddWindow :public QDialog {
public:
    AddWindow(Controller *con, QTableWidget *movieTable);
    void closeWindow();
    void addMov();
private:
    Controller *con;
    QTableWidget *movieTable = new QTableWidget;
    QHBoxLayout *btnLayout = new QHBoxLayout;
    QPushButton *okBtn = new QPushButton("OK");
    QPushButton *cancelBtn = new QPushButton("Cancel");

    QLineEdit *mTitle = new QLineEdit;
    QLineEdit *mGenre = new QLineEdit;
    QLineEdit *mYear = new QLineEdit;
    QLineEdit *mLikes = new QLineEdit;
    QLineEdit *mTrailer = new QLineEdit;

    QVBoxLayout *mainLayout = new QVBoxLayout;
};

class UpdWindow :public QDialog {
public:
    UpdWindow(Controller *con, QTableWidget *movieTable);
    void closeWindow();
    void updMov();
private:
    Controller *con;
    QTableWidget *movieTable = new QTableWidget;
    QHBoxLayout *btnLayout = new QHBoxLayout;
    QPushButton *okBtn = new QPushButton("OK");
    QPushButton *cancelBtn = new QPushButton("Cancel");

    QLineEdit *mTitle = new QLineEdit;
    QLineEdit *mGenre = new QLineEdit;
    QLineEdit *mYear = new QLineEdit;
    QLineEdit *mLikes = new QLineEdit;
    QLineEdit *mTrailer = new QLineEdit;

    QVBoxLayout *mainLayout = new QVBoxLayout;
};
#endif //L7_ADDWINDOW_H
