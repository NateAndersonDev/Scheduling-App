package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public interface UserDao {
   static boolean checkValidUserName(String userName) throws SQLException {
        String sql = "SELECT 1 FROM USERS WHERE User_Name= ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();

        return rs.next();
    }

    static boolean checkMatchPw(String userName, String passWord) throws SQLException{
        String sql = "SELECT Password FROM USERS WHERE User_Name= ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        return(Objects.equals(rs.getString("Password"), passWord));
    }
}

