package bloc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean
@SessionScoped
public class Controller {
    public static void move(char c) {
        if(Repository.gameCount==1)
            System.out.println("YOU WON!");
        else if(Repository.gameCount==2)
            System.out.println("You Lost!");
        if (Repository.startCount == 0) {
            Repository.setFirst();
        }
        switch (c) {
            case 'u':
                Repository.up();
                break;
            case 'd':
                Repository.down();
                break;
            case 'l':
                Repository.left();
                break;
            case 'r':
                Repository.right();
                break;
        }
        Repository.setRand();
        Repository.print();
    }
}