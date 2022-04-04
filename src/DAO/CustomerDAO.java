package DAO;

import Model.Appointments;
import Model.Customer;
import Utilities.GeneralFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerDAO {
    ObservableList<Integer> customerIDist = FXCollections.observableArrayList();
    ObservableList<Customer> customerList = FXCollections.observableArrayList();

    static void getCustomerIdList() throws SQLException {
        String sql = "SELECT Customer_ID FROM CUSTOMERS";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int customerID = rs.getInt("Customer_ID");
            customerIDist.add(customerID);
        }
    }
    static void pullCustomers() throws SQLException {
        String sql = "SELECT * FROM CUSTOMERS";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) { //keeps going if there is data in the rs.
           int customerID = rs.getInt("Customer_ID");
           String customerName = rs.getString("Customer_Name");
           String customerAddress = rs.getString("Address");
           String customerPostalCode = rs.getString("Postal_Code");
           String customerPhone = rs.getString("Phone");
           int customerDivisionID = rs.getInt("Division_ID");
           String country = DivisionDAO.getCountryfromDivId(customerDivisionID);
           String division = DivisionDAO.getDivisionfromDivisionId(customerDivisionID);

            customerList.add(new Customer(customerID,customerName,customerAddress,customerPostalCode,customerPhone,customerDivisionID,country,division));
        }
    }
    static int addNewCustomer(Customer customer) throws SQLException{
        String sql = "INSERT INTO CUSTOMERS(Customer_Name, Address, Postal_Code, Phone, Division_ID)"+
                " VALUES(?,?,?,?,?)";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, customer.getCustomerName());
        ps.setString(2,customer.getCustomerAddress());
        ps.setString(3,customer.getCustomerPostalCode());
        ps.setString(4,customer.getCustomerPhone());
        ps.setInt(5,customer.getCustomerDivisionId());
        return ps.executeUpdate();
    }
    static int updateCustomer(Customer customer) throws SQLException{
        String sql = "UPDATE CUSTOMERS " +
                "SET Customer_Name = ?, " +
                " Address = ?, " +
                " Postal_Code = ?, " +
                " Phone = ?, " +
                " Division_ID = ? " +
                "WHERE Customer_ID = ?;";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, customer.getCustomerName());
        ps.setString(2,customer.getCustomerAddress());
        ps.setString(3,customer.getCustomerPostalCode());
        ps.setString(4,customer.getCustomerPhone());
        ps.setInt(5,customer.getCustomerDivisionId());
        ps.setInt(6,customer.getCustomerId());
        return ps.executeUpdate();
    }

    static int deleteCustomer(Customer customer) throws SQLException {
        AppointmentsDao.deleteAppt(customer.getCustomerId());
        String sql = "DELETE FROM CUSTOMERS WHERE Customer_ID= ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql); //prepared Statement
        ps.setInt(1, customer.getCustomerId());
        return ps.executeUpdate();
    }
}
