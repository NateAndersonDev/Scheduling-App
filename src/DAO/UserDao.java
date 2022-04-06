package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Interface declaration for user objects and the DB.
 */
public interface UserDao {
    ObservableList<Integer> userIDist = FXCollections.observableArrayList();

    /**
     * SQL query to get the user ID.
     * This fucntion populates an observalbe list of the user id's in the DB.
     * @throws SQLException SQLException
     */
    static void getUserIdList() throws SQLException {
        String sql = "SELECT User_ID FROM USERS";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int userID = rs.getInt("User_ID");
            userIDist.add(userID);
        }
    }

    /**
     * SQL query to check a valid user name.
     * This is called by the login controller to check for valid login user names.
     * @param userName username.
     * @return if empty username does not exist.
     * @throws SQLException SQLException.
     */
   static boolean checkValidUserName(String userName) throws SQLException  {
        String sql = "SELECT 1 FROM USERS WHERE User_Name= ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    /**
     * SQL query to check if pw matches username.
     * This function checks to see if the entered password matches the entered username.
     * @param userName entered username
     * @param passWord entered password
     * @return empty if pw does not match
     * @throws SQLException SQLException
     */
    static boolean checkMatchPw(String userName, String passWord) throws SQLException{
        String sql = "SELECT Password FROM USERS WHERE User_Name= ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            return (Objects.equals(rs.getString("Password"), passWord));
        }
        return false;
    }
}

