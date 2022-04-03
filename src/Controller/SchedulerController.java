package Controller;

import DAO.AppointmentsDao;
import DAO.ContactDao;
import DAO.CustomerDAO;
import DAO.UserDao;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;


public class SchedulerController {
    public Button MainModifyAppointmentBtn;
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
    private TableColumn<Appointments, LocalTime> MainEndTimeCol;

    @FXML
    private ComboBox<LocalTime> MainEndTimeCombo;

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
    private TableColumn<Appointments, LocalTime> MainStartTimeCol;

    @FXML
    private ComboBox<LocalTime> MainStartTimeCombo;

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

    ObservableList<String> TypeComboList = FXCollections.observableArrayList(
            "Planning Session",
            "De-Briefing",
            "Yell at Customer Time",
            "Termination meeting",
            "Cry about life at home"
    );
    ObservableList<LocalTime> PossibleStartTimesList = FXCollections.observableArrayList(GeneralFunctions.getStartTimes());
    ObservableList<LocalTime> PossibeEndTimesList = FXCollections.observableArrayList(GeneralFunctions.getStartTimes());



    public void initialize() throws SQLException {

        MainAppointmentTable.getItems().clear();
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

        ContactDao.getContactNameList();
        MainContactNameCombo.setItems(ContactDao.contactNameList);
        MainTypeCombo.setItems(TypeComboList);
        MainStartTimeCombo.setItems(PossibleStartTimesList);
        MainEndTimeCombo.setItems(PossibeEndTimesList);
        CustomerDAO.getCustomerIdList();
        MainCustomerIdCombo.setItems(CustomerDAO.customerIDist);
        UserDao.getUserIdList();
        MainUserIdCombo.setItems(UserDao.userIDist);

        MainAppointmentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        {
            if (newVal != null) {
                MainAppointmentId.setText(String.valueOf(newVal.getAppointmentId()));
                MainAppointmentId.setFocusTraversable(false);
                MainTitle.setText(newVal.getTitle());
                MainLocation.setText(newVal.getLocation());
                MainTypeCombo.valueProperty().setValue(newVal.getType());
                MaineDatePicker.valueProperty().setValue(GeneralFunctions.datePickerFromSelection(newVal.getStart()));
                MainStartTimeCombo.valueProperty().setValue(GeneralFunctions.timeFromSelection(newVal.getStart()));
                MainEndTimeCombo.valueProperty().setValue(GeneralFunctions.timeFromSelection(newVal.getEnd()));
                MainCustomerIdCombo.valueProperty().setValue(newVal.getCustomerId());
                MainUserIdCombo.valueProperty().set(newVal.getUserID());
                MainDescription.setText(newVal.getDescription());
                try {
                    MainContactNameCombo.valueProperty().setValue(ContactDao.getContactName(newVal.getContactId()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
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
   public void SaveBtnPress(ActionEvent event) throws IOException {
           try {
               LocalDate date = MaineDatePicker.getValue();
               LocalTime startTime = MainStartTimeCombo.getValue();
               LocalTime endTime = MainEndTimeCombo.getValue();
               String contactName = MainContactNameCombo.getValue();

               Appointments apptToAdd = new Appointments();
               apptToAdd.setTitle(MainTitle.getText());
               apptToAdd.setLocation(MainLocation.getText());
               apptToAdd.setDescription(MainDescription.getText());
               apptToAdd.setType(MainTypeCombo.getValue());
               apptToAdd.setStart(GeneralFunctions.UserTimeToUTC(date, startTime));
               apptToAdd.setEnd(GeneralFunctions.UserTimeToUTC(date, endTime));
               apptToAdd.setContactId(ContactDao.getContactId(contactName));
               apptToAdd.setCustomerId(MainCustomerIdCombo.getValue());
               apptToAdd.setUserID(MainUserIdCombo.getValue());

               if(Objects.equals(MainAppointmentId.getText(), "Auto-Generated")) {
                   int rowsAffected = AppointmentsDao.addNewAppt(apptToAdd);

                   if (rowsAffected > 0) {
                       GeneralFunctions.successMessage("Appointment Added", "The appointment has been successfully added");
                       MainAppointmentTable.getItems().clear();
                       AppointmentsDao.pullAppointments();
                       MainAppointmentTable.setItems(AppointmentsDao.apptoblist);

                   } else {
                       GeneralFunctions.alertError("Failed", "Appointment not added, check fields for errors");
                   }
               } else{
                   apptToAdd.setAppointmentId(Integer.parseInt(MainAppointmentId.getText()));
                    int rowsAffected = AppointmentsDao.updateAppt(apptToAdd);
                    if (rowsAffected > 0){
                        GeneralFunctions.successMessage("Appointment Updated", "Appointment "+ apptToAdd.getAppointmentId() + " was updated Successfully");
                        MainAppointmentTable.getItems().clear();
                        AppointmentsDao.pullAppointments();
                        MainAppointmentTable.setItems(AppointmentsDao.apptoblist);
                    }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
   }

   public void addNewAppointment(ActionEvent event) throws IOException{
        MainAppointmentId.setText("Auto-Generated");
       MainTitle.clear();
       MainLocation.clear();
       MainDescription.clear();
       MainTypeCombo.valueProperty().set(null);
       MaineDatePicker.valueProperty().set(null);
       MainStartTimeCombo.valueProperty().set(null);
       MainEndTimeCombo.valueProperty().set(null);
       MainCustomerIdCombo.valueProperty().set(null);;
       MainUserIdCombo.valueProperty().set(null);;
       MainContactNameCombo.valueProperty().set(null);;
    }
}




