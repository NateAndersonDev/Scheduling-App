package DAO;

import Model.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDao {

    /*public static ObservableList<Countries> getCountries(){
        ObservableList<Countries> countryList = FXCollections.observableArrayList(); //creates list

        try{
            String sql = "SELECT * from counties"; // Defines SQL statement to get everything from countries table

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql); //connects to the DB

            ResultSet rs = ps.executeQuery(); //gets the result set of running the above

            while(rs.next()){ //loops through the results set
                int countryId = rs.getInt("Country_ID"); //gets country id
                String countryName = rs.getString("Country"); // gets country name
                Countries country = new Countries(countryId, countryName); //creates a new object of type country with the id and name from the DB
                countryList.add(country); //adds the country object to the observable array list
            }

        } catch (SQLException e) { //if there's a problem it will print the stack trace.
            e.printStackTrace();
        }

        return countryList;
    }*/

}
