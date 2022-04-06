package DAO;

import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DivisionDAO interface declaration.
 */
public interface DivisionDAO {
    ObservableList<Division> DivisionsList = FXCollections.observableArrayList();

    /**
     * Get Division from Division ID.
     * This function takes a integer of a division ID and returns a string of the division name from the Database
     * @param divisionCode division id
     * @return division name as a string
     * @throws SQLException SQLException
     */
    static String getDivisionfromDivisionId(int divisionCode) throws SQLException {
        String sql = "SELECT * FROM FIRST_LEVEL_DIVISIONS WHERE Division_ID =?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,divisionCode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getString("Division");
        }
        return null;
    }

    /**
     * Get Country from division id function.
     * This function takes a division id as an interger and returns the country from the database
     * @param divisionCode entered division id
     * @return Country name as a string
     * @throws SQLException SQL exception
     */
    static String getCountryfromDivId(int divisionCode) throws SQLException {
        String sql = "SELECT * FROM FIRST_LEVEL_DIVISIONS WHERE Division_ID =?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, divisionCode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int countryCode = rs.getInt("COUNTRY_ID");
            if(countryCode == 1) {
                return "U.S.";
            } else if(countryCode == 2){
                return "UK";
            } else if(countryCode == 3){
                return "Canada";
            }
        }
        return null;
    }

    /**
     * Pull division List.
     * This function creates a list of all the divisions ID's, their corresponding countries(name) and first level divisions.
     * @throws SQLException SQL exception
     */
    static void pullDivisionList() throws SQLException {
        String sql = "SELECT * FROM FIRST_LEVEL_DIVISIONS";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) { //keeps going if there is data in the rs.
            int divisionId = rs.getInt("Division_ID");
            String countryName = null;
            String divisionName = rs.getString("Division");
            int countryId = rs.getInt("COUNTRY_ID");
                if(countryId == 1) {
                    countryName =  "U.S.";
                } else if(countryId == 2){
                    countryName = "UK";
                } else if(countryId == 3){
                    countryName = "Canada";
                }
            DivisionsList.add(new Division(divisionName, countryName, divisionId));
            }

        }
    }

