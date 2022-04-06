package DAO;

import Model.Appointments;
import Model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ContactDao Interface declaration
 */
public interface ContactDao {
    ObservableList<String> contactNameList = FXCollections.observableArrayList();

    /**
     * Get Contact Name function.
     * This function returns the contact name as a string from a contact id.
     * @param ID Contact ID
     * @return contact name
     * @throws SQLException SQLException
     */
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

    /**
     * Get Contact ID.
     * This function takes a contact name as a string and returns the contact ID as an integer.
     * @param name Contact Name
     * @return contact ID
     * @throws SQLException SQLException
     */
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

    /**
     * Get Contact Name Function
     * This function gets all the contact names from the database and populates an observable list with them
     * @throws SQLException SQLException
     */
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

