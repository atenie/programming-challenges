package bloc;

import java.util.Scanner;

public class TerminalUI {
    void Selector() {
        System.out.println("1.Up");
        System.out.println("2.Down");
        System.out.println("3.Left");
        System.out.println("4.Right");
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        int selection = Integer.parseInt(scanner.nextLine());
        switch (selection) {
            case  (1): {
                controller.move('u');
                break;
            }
            case  (2): {
                controller.move('d');
                break;
            }
            case  (3): {
                controller.move('l');
                break;
            }
            case  (4): {
                controller.move('r');
                break;
            }
            case  (0):{
                return;
            }
            default: {
                System.out.println("Wrong input");
                Selector();
            }
        }
        Selector();
    }
}
