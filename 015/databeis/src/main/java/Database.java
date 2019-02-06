import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection getConnection() throws Exception{
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url ="jdbc:mysql://localhost:3306/Mysql?verifyServerCertificate=false&useSSL=true";
            //ceva terminatie fancy ca sa nu urle dupa mama
            String username = "admin";
            String password = "admin";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username,password);

            return conn;

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
