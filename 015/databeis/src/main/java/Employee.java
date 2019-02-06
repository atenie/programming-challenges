class Employee extends Person {

    public enum jobPosition {DEVELOPER, TESTER, PROJECTMANAGER, TEAMLEADER;}

    public Employee(long ID, String givenName, String familyName, String address, int expLevel, int hoursPerDay, double salaryPerHour, jobPosition job) {
        super(ID, givenName, familyName, address);
        this.expLevel = expLevel;
        this.hoursPerDay = hoursPerDay;
        this.salaryPerHour = salaryPerHour;
        this.job = job;
    }

    int expLevel, hoursPerDay;
    double salaryPerHour;
    jobPosition job;
}
