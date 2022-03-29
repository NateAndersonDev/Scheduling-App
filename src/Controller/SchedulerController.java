package Controller;

import Model.Appointments;
import Model.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class SchedulerController {
    private Parent root;
    private Stage stage;
    ComboBox<String> getMainContactNameCombo;


    @FXML
    private AnchorPane MainScenePane;

    @FXML
    private Button MainAddAppointmentBtn;

    @FXML
    private RadioButton MainAddNewRadioBtn;

    @FXML
    private TableColumn<Appointments, Integer> MainAppointmentIDCol;

    @FXML
    private TableView<Appointments> MainAppointmentTable;

    @FXML
    private TextField MainAppointmentId;

    @FXML
    private TableColumn<Contact, String> MainContactCol;

    @FXML
    private ComboBox<String> MainContactNameCombo;

    @FXML
    private TableColumn<Appointments, Integer> MainCustomerIdCol;

    @FXML
    private ComboBox<Integer> MainCustomerIdCombo;

    @FXML
    private TableColumn<Appointments, Date> MainDateCol;

    @FXML
    private Button MainDeleteAppointmentBtn;

    @FXML
    private TextArea MainDescription;

    @FXML
    private TableColumn<Appointments, String> MainDescriptionCol;

    @FXML
    private TableColumn<Appointments, Time> MainEndTimeCol;

    @FXML
    private ComboBox<Time> MainEndTimeCombo;

    @FXML
    private Button MainExitButton;

    @FXML
    private TextField MainLocation;

    @FXML
    private TableColumn<Appointments, String> MainLocationCol;

    @FXML
    private Button MainModifyCustomerBtn;

    @FXML
    private RadioButton MainModifierDeleteRadioBtn;

    @FXML
    private ComboBox<String> MainMonthComboReport;

    @FXML
    private Button MainReport1GetResultsBtn;

    @FXML
    private TextField MainReportOneMatchingField;

    @FXML
    private ComboBox<String> MainReportTwoContactCombo;

    @FXML
    private Button MainReportTwoGetResultsBtn;

    @FXML
    private TextField MainReportTwoMatchingField;

    @FXML
    private ComboBox<Integer> MainReportTwoUserIdCombo;

    @FXML
    private TableColumn<Appointments, Time> MainStartTimeCol;

    @FXML
    private ComboBox<Time> MainStartTimeCombo;

    @FXML
    private TextField MainTitle;

    @FXML
    private TableColumn<Appointments, String> MainTitleCol;

    @FXML
    private TableColumn<Appointments, String> MainTypeCol;

    @FXML
    private ComboBox<String> MainTypeCombo;

    @FXML
    private ComboBox<String> MainTypeComboReport;

    @FXML
    private TableColumn<Appointments, Integer> MainUserIdCol;

    @FXML
    private ComboBox<Integer> MainUserIdCombo;

    @FXML
    private RadioButton MainViewAllRadioBtn;

    @FXML
    private Button MainViewContactBtn;

    @FXML
    private RadioButton MainViewMonthRadioBtn;

    @FXML
    private RadioButton MainViewWeekRadioBtn;

    @FXML
    private DatePicker MaineDatePicker;


    public void MainOpenContactSchedule(javafx.event.ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/ContactSchedule.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene contactSchedule = new Scene(root);
        stage.setScene(contactSchedule);
        stage.show();
    }
    public void MainOpenCustomer(javafx.event.ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/CustomerForm.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene contactSchedule = new Scene(root);
        stage.setScene(contactSchedule);
        stage.show();
    }
    public void exitApplication(ActionEvent exitApp) {
        stage = (Stage) MainScenePane.getScene().getWindow();
        stage.close();
    }
}




