package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CustomerController {

    @FXML
    private Button CustomerFormCancelBtn;

    @FXML
    private ComboBox<?> CustomerFormCountry;

    @FXML
    private TableColumn<?, ?> CustomerFormCountryCol;

    @FXML
    private Button CustomerFormDeleteButton;

    @FXML
    private TextField CustomerFormID;

    @FXML
    private TableColumn<?, ?> CustomerFormIdCol;

    @FXML
    private RadioButton CustomerFormModifyBtn;

    @FXML
    private TextField CustomerFormName;

    @FXML
    private TableColumn<?, ?> CustomerFormNameCol;

    @FXML
    private TextField CustomerFormPhone;

    @FXML
    private TableColumn<?, ?> CustomerFormPhoneCol;

    @FXML
    private TextField CustomerFormPostal;

    @FXML
    private TableColumn<?, ?> CustomerFormPostalCol;

    @FXML
    private Button CustomerFormSaveBtn;

    @FXML
    private ComboBox<?> CustomerFormState;

    @FXML
    private TableColumn<?, ?> CustomerFormStateCol;

    @FXML
    private TextArea CustomerFormStreet;

    @FXML
    private TableColumn<?, ?> CustomerFormStreetCol;

    @FXML
    private TableView<?> CustomerFormTable;

    @FXML
    private RadioButton CustomerFromAddNewBtn;

}

