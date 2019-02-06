import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonInDatabaseRepository implements CrudRepository {
    /**
     * @param id - the id of the entity to be returned, id must not be null
     * @return the entity with the specified id or null - there is no entity with the given id
     */
    @Override
    public Object findOne(Long id) {
        final int var = Math.toIntExact(id);
        Database db = new Database();
        try {
            Connection connection = Database.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM sys.Persons WHERE ID = " + var);
            while ( rs.next() ) {
                String givenName = rs.getString("givenName");
                String familyName = rs.getString("familyName");
                String address = rs.getString("address");
                Person p = new Person(id, givenName, familyName, address);
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return all entities
     */
    @Override
    public Iterable findAll() {
        Database db = new Database();
        try {
            Connection connection = Database.getConnection();
            Statement stmt = connection.createStatement();
            ArrayList<Person> dbList= new ArrayList<Person>();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM sys.Persons");
            while ( rs.next() ) {
                long id = rs.getInt("ID");
                String givenName = rs.getString("givenName");
                String familyName = rs.getString("familyName");
                String address = rs.getString("address");
                Person p = new Person(id, givenName, familyName, address);
                dbList.add(p);
            }
            return dbList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param entity entity must not be null
     * @return null - if the given entity is saved otherwise returns the entity(id already exists)
     */
    @Override
    public Object save(Object entity) {
        Person p = (Person) entity;
        final int var1 = (int) p.ID;
        final String var2 = p.givenName;
        final String var3 = p.familyName;
        final String var4 = p.address;
        Database db = new Database();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement posted = connection.prepareStatement("INSERT INTO sys.Persons(ID,givenName,familyName,address) VALUES('" + var1 + "','" + var2 + "','" + var3 + "','" + var4 + "')");
            posted.executeUpdate();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param id id must not be null
     * @return the removed entity or null if there is no entity with the given id
     */
    @Override
    public Object delete(Long id) {
        final int var = Math.toIntExact(id);
        Database db = new Database();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement posted = connection.prepareStatement(" DELETE FROM sys.Persons WHERE ID = " + var + ";");
            posted.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g. id does not exist)
     */
    @Override
    public Object update(Object entity) {
        Person p = (Person) entity;
        final int var1 = (int) p.ID;
        final String var2 = p.givenName;
        final String var3 = p.familyName;
        final String var4 = p.address;
        Database db = new Database();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement posted = connection.prepareStatement("UPDATE sys.Persons SET givenName='" + var2 + "', familyName='" + var3 + "', address='" + var4 + "' WHERE ID=" + var1 +";");
            posted.executeUpdate();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
