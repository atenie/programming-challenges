// Tenie Alexandru, Gr.723/2
// Tema 3

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        //do things...
        PersonInDatabaseRepository pd = new PersonInDatabaseRepository();
//        Person p = new Person(1,"Alexandru","Tenie","Bucuresti");
//        Person p1 = new Person(2,"Sandu","Enie","Sector 1");
//        Person p2 = new Person(3,"Sandel","Nie","Sector 5");
//        Person found;
//
//        Iterable dbList= pd.findAll();
//        System.out.println(dbList);

        UI ui = new UI();
        ui.Selector();
    }
}