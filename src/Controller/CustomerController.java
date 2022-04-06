package Controller;

import DAO.*;
import Model.Customer;
import Utilities.GeneralFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;

/**
 * Customer Controller class declaration
 */
public class CustomerController {


    @FXML
    private ComboBox<String> CustomerFormCountry;

    @FXML
    private TableColumn<Customer, String> CustomerFormCountryCol;

    @FXML
    private TextField CustomerFormID;

    @FXML
    private TableColumn<Customer, Integer> CustomerFormIdCol;


    @FXML
    private TextField CustomerFormName;

    @FXML
    private TableColumn<Customer, String> CustomerFormNameCol;

    @FXML
    private TextField CustomerFormPhone;

    @FXML
    private TableColumn<Customer, String> CustomerFormPhoneCol;

    @FXML
    private TextField CustomerFormPostal;

    @FXML
    private TableColumn<Customer, String> CustomerFormPostalCol;

    @FXML
    private ComboBox<String> CustomerFormState;

    @FXML
    private TableColumn<Customer, String> CustomerFormStateCol;

    @FXML
    private TextArea CustomerFormStreet;

    @FXML
    private TableColumn<Customer, String> CustomerFormStreetCol;

    @FXML
    private TableView<Customer> CustomerFormTable;


    ObservableList<String> countryList  = FXCollections.observableArrayList(
            "U.S.",
            "UK",
            "Canada"
    );

    /**
     * Return to main function.
     * This function returns the user to the main Scheduler scene.
     * @param event user presses the button to return to the main scene
     * @throws IOException IOException
     */
    public void ReturnToMain(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Scheduler.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene MainFormScene = new Scene(root);
        stage.setScene(MainFormScene);
        stage.show();
    }

    /**
     * Initialize function.
     * This function populates the table, creates a lambda function listener to do division filtering based on country, and another listener to populate the text fields
     * with values from the selection from the table.
     * @throws SQLException SQLException
     */
    public void initialize() throws SQLException {
        CustomerFormTable.getItems().clear();
        CustomerDAO.customerList.clear();
        DivisionDAO.pullDivisionList();

        CustomerFormTable.getItems().clear();
        CustomerDAO.pullCustomers();
        CustomerFormTable.setItems(CustomerDAO.customerList);
        CustomerFormIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        CustomerFormNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        CustomerFormPhoneCol.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        CustomerFormCountryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        CustomerFormStateCol.setCellValueFactory(new PropertyValueFactory<>("division"));
        CustomerFormPostalCol.setCellValueFactory(new PropertyValueFactory<>("customerPostalCode"));
        CustomerFormStreetCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));


        CustomerFormCountry.setItems(countryList);

        CustomerFormCountry.valueProperty().addListener((obs, oldVal, newVal) ->
        {
            if (newVal != null) {
                {
                    switch (newVal) {
                        case "U.S." -> CustomerFormState.setItems(GeneralFunctions.divisionsFromDivisionList("U.S."));
                        case "UK" -> CustomerFormState.setItems(GeneralFunctions.divisionsFromDivisionList("UK"));
                        case "Canada" -> CustomerFormState.setItems(GeneralFunctions.divisionsFromDivisionList("Canada"));
                    }
                }
            }
        });

        CustomerFormTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        {
            if (newVal != null) {
                CustomerFormID.setText(String.valueOf(newVal.getCustomerId()));
                CustomerFormID.setFocusTraversable(false);
                CustomerFormName.setText(newVal.getCustomerName());
                CustomerFormPhone.setText(newVal.getCustomerPhone());
                CustomerFormStreet.setText(newVal.getCustomerAddress());
                CustomerFormPostal.setText(newVal.getCustomerPostalCode());
                CustomerFormCountry.valueProperty().setValue(newVal.getCountry());
                CustomerFormState.valueProperty().setValue(newVal.getDivision());

            }
        });
    }

    public void CustomerSaveBtnPress() {
            try{
            Customer custToAdd = new Customer();
            custToAdd.setCustomerName(CustomerFormName.getText());
            custToAdd.setCustomerPhone(CustomerFormPhone.getText());
            custToAdd.setCustomerDivisionId(GeneralFunctions.getDivIdFromInput(CustomerFormCountry.getValue(), CustomerFormState.getValue()));
            custToAdd.setCustomerPostalCode(CustomerFormPostal.getText());
            custToAdd.setCustomAddress(CustomerFormStreet.getText());

            if(Objects.equals(CustomerFormID.getText(), "Auto-Generated")){
                int rowsAffected = CustomerDAO.addNewCustomer(custToAdd);
                if (rowsAffected > 0) {
                    GeneralFunctions.successMessage("Customer Added", "The customer has been successfully added");
                    CustomerFormTable.getItems().clear();
                    CustomerDAO.pullCustomers();
                    CustomerFormTable.setItems(CustomerDAO.customerList);

                } else {
                    GeneralFunctions.alertError("Failed", "Customer not added, check fields for errors");
                }
            } else {
                custToAdd.setCustomerId(Integer.parseInt(CustomerFormID.getText()));
                int rowsAffected = CustomerDAO.updateCustomer(custToAdd);
                if (rowsAffected > 0) {
                    GeneralFunctions.successMessage("Customer Updated", "Customer with Id of:  " + custToAdd.getCustomerId() + " was updated Successfully");
                    CustomerFormTable.getItems().clear();
                    CustomerDAO.pullCustomers();
                    CustomerFormTable.setItems(CustomerDAO.customerList);
                }
            }

            } catch (SQLIntegrityConstraintViolationException | NullPointerException e){
                GeneralFunctions.alertError("Fields are empty", "Please ensure all fields have content");
            } catch (SQLException e) {
               e.printStackTrace();
            } catch (NumberFormatException e){
                GeneralFunctions.alertError("Please click 'Add New Customer' button", "User must generate new customer ID by clicking the 'Add New Customer' button before trying to save the customer");
            }
    }

    public void CustomerDeleteButtonRequest() throws SQLException {
        if (!Objects.equals(CustomerFormID.getText(), "")) {
        Customer custToDelete = new Customer();
        custToDelete.setCustomerId(Integer.parseInt(CustomerFormID.getText()));

            if (GeneralFunctions.confirmationMessage("Confirm Delete", "Appointments with this customer will also be deleted",
                    "Confirm you want to delete customer with ID of " + custToDelete.getCustomerId())) {
                int rowsAffected = CustomerDAO.deleteCustomer(custToDelete);
                if (rowsAffected > 0) {
                    GeneralFunctions.successMessage("Customer Deleted", "The Customer and their appointments have been successfully deleted");
                    CustomerFormTable.getItems().clear();
                    CustomerDAO.pullCustomers();
                    CustomerFormTable.setItems(CustomerDAO.customerList);
                } else {
                    GeneralFunctions.alertError("Failed", "Customer and or appointments were not deleted");
                }
            }
        } else {
            GeneralFunctions.alertError("No customer Selected", "Please select customer to delete");
        }
    }

    public void CustomerAddCustBtnPress() throws IOException{
        CustomerFormID.clear();
        CustomerFormID.setText("Auto-Generated");
        CustomerFormName.clear();
        CustomerFormPhone.clear();
        CustomerFormStreet.clear();
        CustomerFormPostal.clear();
        CustomerFormCountry.valueProperty().set(null);
        CustomerFormState.getItems().clear();
    }

}



