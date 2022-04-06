package DAO;

import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Customer DAO class declaration
 */
public interface CustomerDAO {
    ObservableList<Integer> customerIDist = FXCollections.observableArrayList();
    ObservableList<Customer> customerList = FXCollections.observableArrayList();

    /**
     * Get Customer ID list function.
     * This function populates and observable list "Customer list" with customer ID's from the Database
     * @throws SQLException SQLException
     */
    static void getCustomerIdList() throws SQLException {
        String sql = "SELECT Customer_ID FROM CUSTOMERS";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int customerID = rs.getInt("Customer_ID");
            customerIDist.add(customerID);
        }
    }

    /**
     * Pull customers function.
     * This function queries all the customers in the database and populates an observable list with their data.
     * @throws SQLException SQLException
     */
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

    /**
     * Add New Customer Function.
     * This function inserts a new customer object into the database
     * @param customer customer to insert
     * @return 1 if insert was successful.
     * @throws SQLException SQL Exception
     */
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
    /**
     * Update Customer Function.
     * This function updates a customer in the database with the values of the passed customer object
     * @param customer customer to insert
     * @return 1 if update was successful.
     * @throws SQLException SQL Exception
     */
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

    /**
     * Delete customer function.
     * This function deletes a customer from the database using the customer id of the passed in customer object.
     * It also deletes the appointments for the customer.
     * @param customer custer to be deleted
     * @return 1 if delete was successful
     * @throws SQLException SQLException
     */
    static int deleteCustomer(Customer customer) throws SQLException {
        AppointmentsDao.deleteApptCust(customer.getCustomerId());
        String sql = "DELETE FROM CUSTOMERS WHERE Customer_ID= ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql); //prepared Statement
        ps.setInt(1, customer.getCustomerId());
        return ps.executeUpdate();
    }
}
