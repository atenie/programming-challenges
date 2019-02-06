import java.util.List;

class PersonController {
    private CrudRepository repo = new PersonInMemoryRepository();

    List<Person> findAll() {
        Iterable all;
        all = repo.findAll();
        return (List<Person>) all;
    }

    Person savePerson(Person p) {
        repo.save(p);
        return (Person) p;
    }

    Person updatePerson(Person p) {
        repo.update(p);
        return (Person) p;
    }

    Person deletePerson(Long id) {
        repo.delete(id);
        return null;
    }

    double calculateSalary(Employee e, Integer numberOfDays) {
        switch (e.job) {
            case TESTER:
                return 1*numberOfDays*e.expLevel*e.hoursPerDay*e.salaryPerHour;
            case DEVELOPER:
                return 2*numberOfDays*e.expLevel*e.hoursPerDay*e.salaryPerHour;
            case TEAMLEADER:
                return 3*numberOfDays*e.expLevel*e.hoursPerDay*e.salaryPerHour;
            case PROJECTMANAGER:
                return 4*numberOfDays*e.expLevel*e.hoursPerDay*e.salaryPerHour;
        }
        return 0;
    }
}