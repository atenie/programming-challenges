import static org.junit.Assert.*;

public class PersonControllerTest {

    @org.junit.Test
    public void findAll() {
        PersonController p= new PersonController();
        PersonInMemoryRepository p2 = new PersonInMemoryRepository();
        PersonFileRepository p3 = new PersonFileRepository();

        assertEquals(p2.memoryList,p2.findAll());
        assertEquals(p2.memoryList,p3.findAll());
    }

    @org.junit.Test
    public void savePerson() {
        Person p = new Person((long) 4,"A","B","C");
        PersonInMemoryRepository p2 = new PersonInMemoryRepository();
        PersonFileRepository p3 = new PersonFileRepository();

        p2.save(p);
        assertEquals(p,p2.findOne((long) 4));

        p3.save(p);
        assertEquals(p,p3.findOne((long) 4));
        p3.delete((long) 4);
    }

    @org.junit.Test
    public void updatePerson() {
        Person p = new Person((long) 3,"A","B","C");
        Person pBackup = new Person(3,"Adriana","Moldovan","Iasi");
        PersonInMemoryRepository p2 = new PersonInMemoryRepository();
        PersonFileRepository p3 = new PersonFileRepository();

        p2.update(p);
        assertEquals(p,p2.findOne((long) 3));

        p3.update(p);
        assertEquals(p,p3.findOne((long) 3));
        p3.delete((long)3);
        p3.save(pBackup);

    }

    @org.junit.Test
    public void deletePerson() {
        Person p = new Person(3,"Adriana","Moldovan","Iasi");
        PersonInMemoryRepository p2 = new PersonInMemoryRepository();
        PersonFileRepository p3 = new PersonFileRepository();

        p2.delete((long)3);
        assertNull(p2.findOne((long) 3));

        p3.delete((long)3);
        assertNull(p3.findOne((long) 3));
        p3.save(p);
    }

    @org.junit.Test
    public void calculateSalary() {
        Employee e = new Employee(0,"Bob","Bobescu","Baicoi",3,8,12, Employee.jobPosition.TEAMLEADER);
        PersonController pc = new PersonController();
        assertEquals((double)190080.0,pc.calculateSalary(e,220),1);
    }
}