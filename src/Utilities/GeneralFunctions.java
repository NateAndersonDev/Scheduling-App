package Utilities;

import DAO.DBConnection;
import DAO.DivisionDAO;
import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;


public interface GeneralFunctions {
    ZoneId utcZoneId = ZoneId.of("UTC");
    ZoneId myZoneId = ZoneId.systemDefault();
    LocalDateTime userDateTime = LocalDateTime.now(myZoneId);


    static void alertError(String Title, String Header) {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle(Title);
        error.setHeaderText(Header);
        error.show();
    }
    static void successMessage(String Title, String Header){
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle(Title);
        success.setHeaderText(Header);
        success.show();
    }
    static boolean confirmationMessage(String title, String header, String context) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle(title);
        confirmation.setHeaderText(header);
        confirmation.setContentText(context);

        Optional<ButtonType> btn = confirmation.showAndWait();
        if(btn.isPresent()) {
            if (btn.get() == ButtonType.OK) {
                return true;
            } else if (btn.get() == ButtonType.CANCEL) {
                return  false;
            }
        }
        return false;
    }
    static List<LocalTime> getStartTimes(){
        //eastern timezone offset= -04:00
        Integer userOffset = myZoneId.getRules().getOffset(Instant.now()).getTotalSeconds();
        ZoneId business = ZoneId.of("America/New_York");
        Integer businessOffset = business.getRules().getOffset(Instant.now()).getTotalSeconds();
        int diff = (businessOffset-userOffset) /3600;

        String[] mins = {"00", "15", "30", "45"};
        List<LocalTime> times = new ArrayList<LocalTime>();

        for(int i=8-diff; i<22-diff; i++){
            for(int j =0; j<4; j++){
                String time = i + ":" + mins[j];
                if(i<10){
                    time = "0" +time;
                }
                times.add(LocalTime.parse(time));
            }
        }
        return (times);
    }

    static String UserTimeToUTC(LocalDate date, LocalTime time){
        LocalDateTime ldt = LocalDateTime.of(date, time);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, myZoneId);
        ZonedDateTime utczdt = ZonedDateTime.ofInstant(zdt.toInstant(), utcZoneId);
        return (utczdt.toLocalDate().toString() + " " + utczdt.toLocalTime().toString());
    }

    static String UTCTimeToUserTime(String dbUTCTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss");
        LocalDateTime ldt =  LocalDateTime.parse(dbUTCTime, df);
        ZonedDateTime utczdt = ZonedDateTime.of(ldt,utcZoneId);
        ZonedDateTime myzdt = ZonedDateTime.ofInstant(utczdt.toInstant(), myZoneId);
        return (myzdt.toLocalDate().toString() + " " + myzdt.toLocalTime().toString());
    }
    static LocalDate datePickerFromSelection(String datetime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
        LocalDateTime ldt = LocalDateTime.parse(datetime, df);
        return ldt.toLocalDate();
    }
   static LocalTime timeFromSelection(String datetime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
        LocalDateTime ldt = LocalDateTime.parse(datetime, df);
        return ldt.toLocalTime();
    }

    static ObservableList<String> divisionsFromDivisionList(String countryName){
        ObservableList<String> filteredList = FXCollections.observableArrayList();
        DivisionDAO.DivisionsList.forEach(Division -> {
            if(Objects.equals(Division.getCountryName(), countryName)){
                filteredList.add(Division.getDivisionName());
            }
            });
        return filteredList;
        }

    static int getDivIdFromInput(String countryName, String state) {
        for (Division div : DivisionDAO.DivisionsList) {
            if ((div.getCountryName().equals(countryName)) && (div.getDivisionName().equals(state))) {
                return div.getDivisionId();
            }
        }

        return -1;
    }
    }


    //Function that takes First and Second level country data and turn it into a Division ID & Vice Versa.




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