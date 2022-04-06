package DAO;

import Model.Appointments;
import Utilities.GeneralFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * AppointmentsDAO interface declaration
 */
public interface AppointmentsDao {
    ObservableList<Appointments> apptoblist = FXCollections.observableArrayList();

    /**
     * Pull Appointments method.
     * This method quries all the appointments in the database and adds them ato an observable list.
     * @throws SQLException SQLException
     */
    static void pullAppointments() throws SQLException {
        String sql = "SELECT * FROM APPOINTMENTS";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) { //keeps going if there is data in the rs.
            int apptID = rs.getInt("Appointment_ID");
            String title = rs.getString("Title");
            String description = rs.getString("Description");
            String location  = rs.getString("Location");
            String type = rs.getString("Type");
            String startTime = GeneralFunctions.UTCTimeToUserTime(rs.getString("Start"));
            String endTime = GeneralFunctions.UTCTimeToUserTime(rs.getString("End"));
            int customerID = rs.getInt("Customer_ID");
            int userID = rs.getInt("User_ID");
            int contactID = rs.getInt("Contact_ID");

            apptoblist.add(new Appointments(apptID,title,description,location,type,startTime,endTime,customerID,userID,contactID));
        }
    }

    /**
     * Add new appointment function.
     * This function takes an appointment object and inserts it into the database.
     * @param appointments appointment to be inserted
     * @return 1 if insert successful.
     * @throws SQLException SQLException
     */
    static int addNewAppt(Appointments appointments) throws SQLException{
        String sql = "INSERT INTO APPOINTMENTS(Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID)" +
                " VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, appointments.getTitle());
        ps.setString(2, appointments.getDescription());
        ps.setString(3, appointments.getLocation());
        ps.setString(4,appointments.getType());
        ps.setString(5, appointments.getStart());
        ps.setString(6,appointments.getEnd());
        ps.setInt(7,appointments.getCustomerId());
        ps.setInt(8,appointments.getUserID());
        ps.setInt(9,appointments.getContactId());
        return ps.executeUpdate();
    }

    /**
     * Update Appointment Function.
     * This function takes an appointment object and updates the corresponding appointment in the db based on appointment id.
     * @param appointments appointment to be updated
     * @return 1 if update successful
     * @throws SQLException SQLException
     */
    static int updateAppt(Appointments appointments) throws SQLException{
        String sql = "UPDATE APPOINTMENTS " +
                "SET Title = ?, " +
                " Description = ?, " +
                " Location = ?, " +
                " Type = ?, " +
                " Start = ?, " +
                " End = ?, " +
                " Customer_ID = ?, " +
                " User_ID = ?, " +
                " Contact_ID = ? " +
                "WHERE Appointment_ID = ?;";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, appointments.getTitle());
        ps.setString(2, appointments.getDescription());
        ps.setString(3, appointments.getLocation());
        ps.setString(4,appointments.getType());
        ps.setString(5, appointments.getStart());
        ps.setString(6,appointments.getEnd());
        ps.setInt(7,appointments.getCustomerId());
        ps.setInt(8,appointments.getUserID());
        ps.setInt(9,appointments.getContactId());
        ps.setInt(10,appointments.getAppointmentId());
        return ps.executeUpdate();
    }

    /**
     * Delete Appointment function.
     * This function takes an appointment ID and deletes the corresponding appointment from the database.
     * @param AppointmentId id of the referenced appointment to be deleted
     * @return 1 if successful
     * @throws SQLException SQLException
     */
    static int deleteAppt(int AppointmentId) throws SQLException{
        String sql = "DELETE FROM Appointments WHERE Appointment_ID = ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, AppointmentId);
        return ps.executeUpdate();
    }

    /**
     * Delete appointment customer.
     * This fucntion deletes an appointment if it contains the corresponding customer ID.
     * @param customerId corresponding customer id.
     * @return 1 if successful
     * @throws SQLException SQLException
     */
    static int deleteApptCust(int customerId) throws SQLException{
        String sql = "DELETE FROM Appointments WHERE Customer_ID= ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, customerId);
        return ps.executeUpdate();
    }
}


