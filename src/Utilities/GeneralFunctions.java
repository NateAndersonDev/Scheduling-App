package Utilities;

import DAO.DBConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Objects;


public interface GeneralFunctions {

    ZoneId myZoneId = ZoneId.systemDefault();
    LocalDateTime userDateTime = LocalDateTime.now(myZoneId);


    static void alertError(String Title, String Header) {
        Alert general = new Alert(Alert.AlertType.ERROR);
        general.setTitle(Title);
        general.setHeaderText(Header);
        general.show();
    }
  /* static String timeUTCtoLocal(Timestamp timestamp){
        ZonedDateTime myZDT = ZonedDateTime.ofInstant(timestamp.toInstant(), myZoneId);
        return (myZDT.toLocalDate() + " " + myZDT.toLocalTime());
    }*/

   /* static Timestamp (LocalDate date, LocalTime time){
        LocalDateTime ldt = LocalDateTime.of(date, time);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, myZoneId);
        ZoneId utcZoneId = ZoneId.of("UTC");
        ZonedDateTime utcZDT = ZonedDateTime.ofInstant(zdt.toInstant(), utcZoneId);
        return utcZDT;
    }*/
    static void getZonedDateTime(LocalDate date, LocalTime time){
        LocalDateTime ldt = LocalDateTime.of(date, time);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, myZoneId);
        System.out.println(zdt);
    }

    /*  static String timeLocalToEastern(LocalDate date, LocalTime time){
        LocalDateTime ldt = LocalDateTime.of(date, time);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, myZoneId);
        ZoneId eastZoneId = ZoneId.of("US/Eastern");
        ZonedDateTime eastZDT = ZonedDateTime.ofInstant(zdt.toInstant(), eastZoneId);
    }*/




//------------ Time Zone Stuff ---------------/
/*
    ZoneId.getAvailableZoneIds().stream.sorted.forEach(system.out::prinln);
    ------prints availabe zone ids

    ZoneID.Systemdefault
    ----- gets user's zone ID

    ZoneId.getAvailableZoneIds().stream.filter(z -> z.contains("America").forEach(system.out::prinln);
    -------lambda function that filters list of zone ID to america timezones.

    date picker returns local date format

    LocalDate myLD = LocalDate.of(2020,10,11);

    set combobox to local time, give list of available local time objects

    LocalTime myLT = LocalTime.of(22, 0); --creates local time object
    LocalDateTime myLDT = LocalDateTime.of(myLD,myLT); ---creates local date/time object
    ZoneID myzoneid = ZoneId.systemDefault();
    ZoneDateTime myZDT = ZoneDateTime.of(myLDT, myzoneid) --creates zonedatetime object

    Extract components:
    myZDT.toLocalDate --display's just the date
    myZDT.toLocalTime --displays just the time

    database time format = (myZDT.tolocalDate.toString() + " " + myZDT.toLocalTime.toString()) -- insert this into database

    ______________HOW TO CONVERT TIMEZONES_______________________
    -----converts usertime into UTC time--------------(myZDT -> utcZDT)---------------
    USER TIME = myZDT
    ZoneID utcZoneId = ZoneID.of("UTC);
    ZonedDateTime utcZDT = ZonedDateTime.ofInstant(myZDT.toInstant(), utcZoneId);

    -------converts UTC time to usertime ---------------(utcZDT -> myZDT)------------

    myZDT = ZonedDateTime.ofInstant(utcZDT.toInstant(), myzoneid);
*/
    /*
    WRITE SOME FUNCTION TO GET CONTACT ID FROM CONTACT NAME
    public long getContactID(String contactName)
    }

    WRITE SOME FUNCTION TO GET CONTACT NAME FROM CONTACT ID

    Function that takes First and Second level country data and turn it into a Division ID & Vice Versa.

    Functions that converts between all the timezones. UTC -> Local, UTC -> Eastern, System -> UTC etc.
    This will save you lots of time and headache. Make these, test these and you will save the hardest part of your project.
    Use LocalDateTime objects and ZoneID’s to do this. There are resources online.
 */

}

//executeUpdate() --returns number of rows affected by the Delete, Insert, or Update SQL command.
//IF a column auto-increments, do not include column in the statement.
//Create an abstract class to run the queries.


//************************************************************************/ EXECUTE UPDATE() /********************************************************************//

//********************************** INSERT INTO SQL ****************************//

/*public static int insert(String fruitname, int colorid) throw SQLException{
    String sql ="INSERT INTO FRUITS (Fruit_Name, Color_id) VALUES(?, ?)"; //? marks are bind variables, start their index at 1
    PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql); //creates a prepared statement
    ps.setString(1,fruitname); //parameterIndex = ?[1]
    ps.setInt(2,colorid); // parameterIndex = ?[2]
    int rowsAffected = ps.executeUpdate(); //return number of rows affected after inserting
    return rowsAffected;

    ************* EXTERNAL METHOD CALL ****************
    int rowsAffected = "CLASS".insert(Cherries, 1);
    if(rowsAffected > 0){
    "INSERT SUCCESSFUL"
    } else {
    "INSERT FAILED"
    }
}*/

//********************************** UPDATE SQL ****************************//

/*
public static int update(int fruitId, String fruitName) throw SQLException{
    String sql = "UPDATE FRUITS SET Fruit_Name = ? WHERE Fruit_ID = ?"//update value =?, at key =?
    PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql); //prepared Statement
    ps.setString(1,fruitName);
    ps.setInt(2,fruitId);
    int rowsAffected = ps.executeUpdate();
    return rowsAffected;

    ************* EXTERNAL METHOD CALL ****************
    int rowsAffected = XXXXX.update(7, "Red Peppers");
    if(rowsAffected > 0){
    "Update SUCCESSFUL"
    } else {
    "Update FAILED"
    }
}*/

//********************************** DELETE SQL ****************************//
/*
public static int delete(int fruitId) throw SQLException{
    String sql ="DELETE FROM FRUITS WHERE Fruit_ID= ?";
    PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql); //prepared Statement
    ps.setInt(1,fruitID);
    int rowsAffected = ps.executeUpdate();
    return rowsAffected;

    ************* EXTERNAL METHOD CALL ****************
    int rowsAffected = XXXXX.update(7);
    if(rowsAffected > 0){
    "Delete SUCCESSFUL"
    } else {
    "Delete FAILED"
    }
}*/

//*****************************************************************/ executeQuery /*****************************************************************************/
//returns resultsSet from the select query
//resultsSet is a 2 dimensional list that contains rows and columns from query
//next method moves through result set
//if there is data in the set, next() = true
//if there is no data next() = false.
//Use resultSet getter method, specifying column number, or column label
// getString -varchar char
// get int - int
// time -timestamp

//***********************************************************/ PULLS OUT ALL DATA FROM TABLE /*****************************************************/
/*
public static void select() throws SQLException {
    String sql = "SELECT * FROM FRUITS"
    PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){ //keeps going if there is data in the rs.
        int fruitId = rs.getInt("Fruit_ID"); //retrieves data from the rs and assigns to fruitID
        String fruitName = rs.getString("Fruit_name");//retrieves data from the rs and assigns to FruitName

    }

}*/
//***********************************************************/ ACCEPTS BLIND VARIABLE TO SELECT PARTICULAR THINGS /*****************************************************/
/*
public static void select(int colorID) throws SQLException {
    String sql = "SELECT * FROM FRUITS WHERE Color_ID = ?";
    PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
    ps.setInt(1,colorID); //Specifies the Color_ID  for the select statements
    ResultSet rs = ps.executeQuery();
    while(rs.next()){ //keeps going if there is data in the rs.
        int fruitId = rs.getInt("Fruit_ID"); //retrieves data from the rs and assigns to fruitID
        String fruitName = rs.getString("Fruit_name");//retrieves data from the rs and assigns to FruitName
        int colorIdfk = rs.getInt("Color_ID");// retrieves color ID from table.

    }

}*/