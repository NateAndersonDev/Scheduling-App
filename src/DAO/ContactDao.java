package DAO;

import Model.Appointments;
import Model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ContactDao {
    ObservableList<String> contactNameList = FXCollections.observableArrayList();

    static String getContactName(int ID) throws SQLException {
        try {
            String sql = "SELECT Contact_Name FROM CONTACTS WHERE Contact_ID = ?";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("Contact_Name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        static int getContactId(String name) throws SQLException{
            try {
                String sql = "SELECT Contact_ID FROM CONTACTS WHERE Contact_Name = ?";
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
                ps.setString(1,name);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    return rs.getInt("Contact_ID");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return -1;
        }

        static void getContactNameList() throws SQLException {
            String sql = "SELECT * FROM Contacts";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String contactName = rs.getString("Contact_Name");
                contactNameList.add(contactName);
            }
        }
}

