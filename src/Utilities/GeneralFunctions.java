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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Alert utility functions.
 */
public class GeneralFunctions {
    /**
     * Passes in a title and header string to display them as an error.
     * @param Title title of the error
     * @param Header header of the error
     */
    public void alertError(String Title, String Header) {
        Alert general = new Alert(Alert.AlertType.ERROR);
        general.setTitle(Title);
        general.setHeaderText(Header);
        general.show();
    }
    public void returnToScheduler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Scheduler.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene MainFormScene = new Scene(root);
        stage.setScene(MainFormScene);
        stage.show();
    }

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
    int rowsAffected = XXXXX.insert(Cherries, 1);
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