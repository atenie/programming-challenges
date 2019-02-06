import java.util.Scanner;

public class UI {
    //to be defined
    int IncomeFromWorkDays() {
        return 0;
    }

    //to be defined
    //for salaries.txt
    //a) venit pentru toti salariatii care sunt jobul X
    //b) venit pt toti salatiatii
    //c)venit pt toti salariatii de un anume nivel
    void Report() {

    }

    //to be defined
    //File or PersonInMemory
    //
    void Selector() {
        PersonController pc = new PersonController();
        PersonInDatabaseRepository pd = new PersonInDatabaseRepository();
        System.out.println("Enter your selection: 1.File, 2.Memory or 8. Database ");
        Scanner scanner = new Scanner(System.in);
        int selection = Integer.parseInt(scanner.nextLine());
        switch (selection) {
            case (1): {

            }
            case (2): {
                System.out.println("__________________");
                System.out.println("3.Find all persons");
                System.out.println("4.Save a person"); // from what?
                System.out.println("5.Update a person");
                System.out.println("6.Delete a person");
                System.out.println("7.Generate salary calculations");
                System.out.println("Enter your selection: ");
                int sel = Integer.parseInt(scanner.nextLine());
                switch (sel) {
                    case (3): {
                        System.out.println(pc.findAll());
                        break;
                    }
                    case (4): {
                        System.out.println("__________________");
                        System.out.println("ID");
                        long id = Long.parseLong(scanner.nextLine());
                        System.out.println("Given Name");
                        String givenName = scanner.nextLine();
                        System.out.println("Family Name");
                        String familyName = scanner.nextLine();
                        System.out.println("Address");
                        String address = scanner.nextLine();
                        Person p = new Person(id, givenName, familyName, address);
                        pc.savePerson(p);
                        break;
                    }
                    case (5): {
                        System.out.println("__________________");
                        System.out.println("ID");
                        long id = Long.parseLong(scanner.nextLine());
                        System.out.println("Given Name");
                        String givenName = scanner.nextLine();
                        System.out.println("Family Name");
                        String familyName = scanner.nextLine();
                        System.out.println("Address");
                        String address = scanner.nextLine();
                        Person p = new Person(id, givenName, familyName, address);
                        pc.updatePerson(p);
                        break;
                    }
                    case (6): {
                        System.out.println("__________________");
                        long id = scanner.nextLong();
                        pc.deletePerson(id);
                        break;
                    }
                    case (7): {
                        System.out.println("all people here are jobless :(");
                        break;
                    }
                }
                Selector();
            }
            case (8): {
                System.out.println("__________________");
                System.out.println("9.Find all persons");
                System.out.println("10.Save a person"); // from what?
                System.out.println("11.Update a person");
                System.out.println("12.Delete a person");
                System.out.println("13.Generate salary calculations");
                System.out.println("Enter your selection: ");
                int sel = Integer.parseInt(scanner.nextLine());
                switch (sel) {
                    case (9): {
                        System.out.println(pd.findAll());
                        break;
                    }
                    case (10): {
                        System.out.println("__________________");
                        System.out.println("ID");
                        long id = Long.parseLong(scanner.nextLine());
                        System.out.println("Given Name");
                        String givenName = scanner.nextLine();
                        System.out.println("Family Name");
                        String familyName = scanner.nextLine();
                        System.out.println("Address");
                        String address = scanner.nextLine();
                        Person p = new Person(id, givenName, familyName, address);
                        pd.save(p);
                        break;
                    }
                    case (11): {
                        System.out.println("__________________");
                        System.out.println("ID");
                        long id = Long.parseLong(scanner.nextLine());
                        System.out.println("Given Name");
                        String givenName = scanner.nextLine();
                        System.out.println("Family Name");
                        String familyName = scanner.nextLine();
                        System.out.println("Address");
                        String address = scanner.nextLine();
                        Person p = new Person(id, givenName, familyName, address);
                        pd.update(p);
                        break;
                    }
                    case (12): {
                        System.out.println("__________________");
                        long id = scanner.nextLong();
                        pd.delete(id);
                        break;
                    }
                    case (13): {
                        System.out.println("all people here are jobless :(");
                        break;
                    }
                }
                Selector();
            }
            case (0): {
                return;
            }
            default: {
                System.out.println("Wrong input");
                Selector();
            }
        }
    }
}
