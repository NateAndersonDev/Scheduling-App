package DAO;

import Main.main;
import Model.Appointments;
import Utilities.GeneralFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public interface AppointmentsDao {
    ObservableList<Appointments> apptoblist = FXCollections.observableArrayList();

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
        int rowsAffected = ps.executeUpdate(); //return number of rows affected after inserting
        return rowsAffected;
    }
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
        int rowsAffected = ps.executeUpdate(); //return number of rows affected after inserting
        return rowsAffected;
    }
}
/*
    ************* EXTERNAL METHOD CALL ****************
        int rowsAffected = XXXXX.insert(Cherries, 1);
        if(rowsAffected > 0){
            "INSERT SUCCESSFUL"
        } else {
            "INSERT FAILED"
        }
    }
}*/
