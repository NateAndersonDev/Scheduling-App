package DAO;
import java.sql.*;

public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost::3306/"; //put name of database here after foreward slash
    private static final String username= "sqlUser";
    private static final String password= "passw0rd!";
    static Connection connection;

    public static void makeConnection() throws ClassNotFoundException, SQLException, Exception{
        connection=(Connection) DriverManager.getConnection(DB_URL,username,password);
    }
    public static void closeConnection() throws ClassNotFoundException, SQLException, Exception{
        connection.close();
    }
}
