package DAO;

import Main.main;
import Model.Appointments;
import Utilities.GeneralFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
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
            Timestamp startTime = (rs.getTimestamp("Start"));
            Timestamp endTime = (rs.getTimestamp("End"));
            int customerID = rs.getInt("Customer_ID");
            int userID = rs.getInt("User_ID");
            int contactID = rs.getInt("Contact_ID");
            Date date = rs.getDate("Start");
            apptoblist.add(new Appointments(apptID,title,description,location,type,startTime,endTime,customerID,userID,contactID, date));
        }
    }

    static int insert(Appointments appointments, LocalDate date, LocalTime time) throws SQLException{
        String sql = "INSERT INTO APPOINTMENTS(Appointment_ID, Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, appointments.getAppointmentId());
        ps.setString(2, appointments.getTitle());
        ps.setString(3, appointments.getDescription());
        ps.setString(4, appointments.getLocation());
        ps.setString(5,appointments.getType());
        ps.setTimestamp(6, appointments.getStart());
        ps.setTimestamp(7,appointments.getEnd());
        ps.setInt(8,appointments.getCustomerId());
        ps.setInt(9,appointments.getUserID());
        ps.setInt(10,appointments.getContactId());
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
