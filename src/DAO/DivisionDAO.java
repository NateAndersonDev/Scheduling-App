package DAO;

import Model.Appointments;
import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DivisionDAO {
    ObservableList<Division> DivisionsList = FXCollections.observableArrayList();

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

