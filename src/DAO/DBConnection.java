package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnection {

    //********************************** VM DATABASE *******************************//
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress ="//wgudb.ucertify.com:3306/";
    private static final String dbName = ""; //dbName

    private static final String jdbcURL = protocol+vendorName+ipAddress+dbName +"?connectionTimeZone=SERVER";

    private static final String MYSQLJBCDriver = "com.mysql.jdbc.Driver";

    private static final String username = ""; //Username
    private static Connection conn=null;

    public static Connection startConnection(){
        try{
            Class.forName(MYSQLJBCDriver);
            conn = DriverManager.getConnection(jdbcURL, username ,Password.getPassword()); //fine with driver manager
            System.out.println("connection successful");
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
        } catch (Exception e){
            //do nothing
        }
    }
    public static Connection getConnection(){
        return conn;
    }

}

//********************************* LOCAL DATABASE ****************************************//
// -- go into code repo and copy/paste the JDBC_source.txt into here
// -- pass word

