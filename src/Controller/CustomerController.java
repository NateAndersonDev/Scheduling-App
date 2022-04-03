package Controller;

import DAO.*;
import Model.Customer;
import Utilities.GeneralFunctions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class CustomerController {

    @FXML
    private Button CustomerFormCancelBtn;

    @FXML
    private ComboBox<String> CustomerFormCountry;

    @FXML
    private TableColumn<Customer, String> CustomerFormCountryCol;

    @FXML
    private Button CustomerFormDeleteButton;

    @FXML
    private TextField CustomerFormID;

    @FXML
    private TableColumn<Customer, Integer> CustomerFormIdCol;

    @FXML
    private RadioButton CustomerFormModifyBtn;

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
    private Button CustomerFormSaveBtn;

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

    @FXML
    private RadioButton CustomerFromAddNewBtn;

    public void ReturnToMain(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Scheduler.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene MainFormScene = new Scene(root);
        stage.setScene(MainFormScene);
        stage.show();
    }
    public void initialize() throws SQLException {

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
    }
    public void CustomerSaveBtnPress(){};
    public void CustomerDeleteButtonRequest(){};
    public void CustomerAddCustBtnPress(){};
}
//
//        ContactDao.getContactNameList();
//        MainContactNameCombo.setItems(ContactDao.contactNameList);
//        MainTypeCombo.setItems(TypeComboList);
//        MainStartTimeCombo.setItems(PossibleStartTimesList);
//        MainEndTimeCombo.setItems(PossibeEndTimesList);
//        CustomerDAO.getCustomerIdList();
//        MainCustomerIdCombo.setItems(CustomerDAO.customerIDist);
//        UserDao.getUserIdList();
//        MainUserIdCombo.setItems(UserDao.userIDist);
//
//        CustomerFormTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
//        {
//            if (newVal != null) {
//                CustomerFormID.setText(String.valueOf(newVal.getCustomerId()));
//                CustomerFormID.setFocusTraversable(false);
//                CustomerFormName.setText(newVal.getCustomerName());
//                CustomerFormPhone.setText(newVal.getCustomerPhone());
//                CustomerFormStreet.setText(newVal.getCustomerAddress());
//                CustomerFormPostal.setText(newVal.getCustomerPostalCode());
//                MainStartTimeCombo.valueProperty().setValue(GeneralFunctions.timeFromSelection(newVal.getStart()));
//                MainEndTimeCombo.valueProperty().setValue(GeneralFunctions.timeFromSelection(newVal.getEnd()));
//                MainCustomerIdCombo.valueProperty().setValue(newVal.getCustomerId());
//                MainUserIdCombo.valueProperty().set(newVal.getUserID());
//                MainDescription.setText(newVal.getDescription());
//                try {
//                    MainContactNameCombo.valueProperty().setValue(ContactDao.getContactName(newVal.getContactId()));
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        });


