package Controller;

import DAO.AppointmentsDao;
import Main.main;
import Model.Appointments;
import Model.Contact;
import Utilities.GeneralFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

public class SchedulerController {
    public Button MainModifyAppointmentBtn;
    public Button MainGetNewID;
    private Parent root;
    private Stage stage;
    ComboBox<String> getMainContactNameCombo;


    @FXML
    private AnchorPane MainScenePane;

    @FXML
    private Button MainAddAppointmentBtn;

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



    public void initialize() throws SQLException {
        AppointmentsDao.pullAppointments();
        MainAppointmentTable.setItems(AppointmentsDao.apptoblist);
        MainAppointmentIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        MainTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        MainLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        MainContactCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        MainTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        MainStartTimeCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        MainEndTimeCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        MainCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        MainUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
        MainDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
    }
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
   public void addNewAppointment(ActionEvent event) throws IOException {
        try{
            int apptID = Integer.parseInt(MainAppointmentId.getText());// auto generate- get from sql.
            String title = MainTitle.getText();
            String location = MainLocation.getText();
            String description = MainDescription.getText();
            String type = MainTypeCombo.getValue().toString();
            LocalDate date = MaineDatePicker.getValue();
            LocalTime startTime = MainStartTimeCombo.getValue().toLocalTime();
            LocalTime endTime = MainEndTimeCombo.getValue().toLocalTime();
            int custId = MainCustomerIdCombo.getValue();
            int userId = MainUserIdCombo.getValue();
            String contactName = MainContactNameCombo.getValue();


            Appointments appttoadd = new Appointments(apptID,title,description,location,type,startTime,endTime,custId,userId,)
            int rowsAffected = AppointmentsDao.insert();

            if(rowsAffected > 0){
                "INSERT SUCCESSFUL"
            } else {
                "INSERT FAILED"
            }
        }


    }


}




