import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonFileRepository implements CrudRepository {

    @Override
    public Object findOne(Long id) {
        Scanner scanner = null;
        File file = new File("C:\\Users\\alex_\\IdeaProjects\\tema3\\src\\persons.txt");

        boolean trigger=false;
        String nextLine;
        String[] humanParts = new String[0];

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long foundID=0;
        // split the file into parts.
        while(scanner.hasNextLine()&&trigger==false) {
            nextLine = scanner.nextLine();
            humanParts = nextLine.split(",");
            foundID = Long.parseLong(humanParts[0]);
            if(foundID==id)
                trigger=true;
        }
        scanner.close();

        // get the components of our vehicle.
        String givenName=humanParts[1];
        String lastName=humanParts[2];
        String address=humanParts[3];
        Person p = new Person(foundID,givenName,lastName,address);
        if(address!=null&&foundID==id)
            return p;
        else return null;
    }

    @Override
    public Iterable findAll() {
        long id = 0;
        ArrayList<Object> result = new ArrayList<>();
        while (findOne(id)!=null) {
            result.add(findOne(id));
            id = id + 1;
        }
        if(!result.isEmpty())
            return result;
        else return null;
    }

    @Override
    public Object save(Object entity) {
        Person p = (Person) entity;
        ArrayList<Object> something = (ArrayList<Object>) findAll();
        if (something.contains(p)) {
            System.out.println("EXISTA!");
            return null;
        }
        else {
            File file = new File("C:\\Users\\alex_\\IdeaProjects\\tema3\\src\\persons.txt");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, true);
                fr.write("\n" + "" + p.ID + "," + p.givenName + "," + p.familyName + "," + p.address + ",");
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return entity;
        }
    }

    @Override
    public Object delete(Long id) {
        String inputFileName = "C:\\Users\\alex_\\IdeaProjects\\tema3\\src\\persons.txt";
        String outputFileName = "C:\\Users\\alex_\\IdeaProjects\\tema3\\src\\temp.txt";
        Person p = (Person) findOne(id);
        String lineToRemove = String.valueOf(p.ID);
        try {
            File inputFile = new File(inputFileName);
            File outputFile = new File(outputFileName);
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                String line = reader.readLine();
                boolean trigger = false;
                if(p.ID!=0) {
                    if (line != null && !line.contains(String.valueOf(p.ID)))
                        writer.write(line);
                    while ((line = reader.readLine()) != null) {
                        if (!line.contains(lineToRemove)) {
                            writer.newLine();
                            writer.write(line);
                        }
                    }
                }
                else {
                    while ((line = reader.readLine()) != null) {
                        if (!line.contains(lineToRemove)&& trigger) {
                            writer.newLine();
                            writer.write(line);
                        }
                        if (!line.contains(lineToRemove)&& !trigger){
                            writer.write(line);
                            trigger=true;
                        }
                    }
                }
            }
            if (inputFile.delete()) {
                if (!outputFile.renameTo(inputFile)) {
                    throw new IOException("Could not rename " + outputFileName + " to " + inputFileName);
                }
            } else {
                throw new IOException("Could not delete original input file " + inputFileName);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Object update(Object entity) {
        Person p = (Person) entity;
        if(findOne(p.ID)== null)
            return null;
        long nr =p.getID();
        delete(nr);
        save(entity);
        return entity;
    }
}
