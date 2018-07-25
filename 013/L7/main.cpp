#include <iostream>
#include <QtWidgets/QApplication>
#include "Controller.h"
#include "MainWindow.h"

int main(int argc, char* argv[]) {
    QApplication app(argc, argv);
    Controller* con = new Controller(new Repository);
    
    con->addMovieToDB("Bad Lieutenant: Port of Call New Orleans", "Drama", 2009, 20, "https://www.youtube.com/watch?v=9OblPKObX6Q");
    con->addMovieToDB("Wild at Heart","Action",1989,19,"https://www.youtube.com/watch?v=QCQwumNQL9E");
    con->addMovieToDB("Con Air","Action",1997,18,"https://www.youtube.com/watch?v=WXgcE6_xfR0");
    con->addMovieToDB("Leaving Las Vegas","Comedy",1995,5,"https://www.youtube.com/watch?v=Ke6kU0rD8Jg");
    con->addMovieToDB("Adaptation","Comedy",2002,40,"https://www.youtube.com/watch?v=BMwOEkTmTyQ");
    con->addMovieToDB("Face/Off","SF",1997,2,"https://www.youtube.com/watch?v=95VvTW1FvS8");
    con->addMovieToDB("The Wicker Man","Drama",2006,5,"https://www.youtube.com/watch?v=tlvqLOo6apM");
    con->addMovieToDB("Raising Arizona","Drama",1987,9,"https://www.youtube.com/watch?v=2AIfVoGUs6c");
    std::shared_ptr<Movie> m(new Movie("La Bloc", "Religie", 666, 5, "https://www.youtube.com/watch?v=pYD5O6iInKs"));
    con->addMovieToWL(m);

    MainWindow window(con);
    window.resize(500, 350);
    window.setWindowTitle("MovieDB 3000");
    window.show();
    QApplication::exec();
    delete(con);
    return 0;
}