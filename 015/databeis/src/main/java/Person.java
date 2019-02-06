import java.util.Objects;

public class Person {

    long ID;
    String givenName;
    String familyName;

    public Person(long ID, String givenName, String familyName, String address) {
        this.ID = ID;
        this.givenName = givenName;
        this.familyName = familyName;
        this.address = address;
    }

    String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getID() == person.getID() &&
                Objects.equals(getGivenName(), person.getGivenName()) &&
                Objects.equals(getFamilyName(), person.getFamilyName()) &&
                Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getGivenName(), getFamilyName(), getAddress());
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
