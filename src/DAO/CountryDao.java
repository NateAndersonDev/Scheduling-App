package DAO;

import Model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CountryDao {

    static void pullCountryName(int countryId) throws SQLException {
        String sql = "SELECT Country FROM COUNTRIES WHERE Country_ID =?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,countryId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String country = rs.getString("Country");
        }
    }

}
