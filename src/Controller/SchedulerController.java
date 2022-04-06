package Controller;

import DAO.AppointmentsDao;
import DAO.ContactDao;
import DAO.CustomerDAO;
import DAO.UserDao;
import Model.Appointments;
import Model.Contact;
import Utilities.GeneralFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * Scheduler Controller class declaration.
 */
public class SchedulerController {
    public Button MainModifyAppointmentBtn;
    public ComboBox MainTypeComboReport1;
    private Stage stage;



    @FXML
    private AnchorPane MainScenePane;

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
    private TextArea MainDescription;

    @FXML
    private TableColumn<Appointments, String> MainDescriptionCol;

    @FXML
    private TableColumn<Appointments, LocalTime> MainEndTimeCol;

    @FXML
    private ComboBox<LocalTime> MainEndTimeCombo;

    @FXML
    private TextField MainLocation;

    @FXML
    private TableColumn<Appointments, String> MainLocationCol;


    @FXML
    private ComboBox<String> MainMonthComboReport;

    @FXML
    private TextField MainReportOneMatchingField;

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
    private RadioButton MainViewMonthRadioBtn;

    @FXML
    private RadioButton MainViewWeekRadioBtn;

    @FXML
    private DatePicker MaineDatePicker;

    /**
     * Radio selection.
     * Defines which function to call to populate the visible table view depending on the radio button selection.
     */
    @FXML
    void RadioSelection() {
        if (MainViewWeekRadioBtn.isSelected()) {

            MainAppointmentTable.setItems(weeklist);
            System.out.println("week selected");
        } else if (MainViewMonthRadioBtn.isSelected()) {

            MainAppointmentTable.setItems(monthlist);
            System.out.println("month selected");
        } else if (MainViewAllRadioBtn.isSelected()) {

            MainAppointmentTable.setItems(AppointmentsDao.apptoblist);
            System.out.println("All selected");
        }
    }

    ObservableList<String> TypeComboList = FXCollections.observableArrayList(
            "Planning Session",
            "De-Briefing",
            "Yell at Customer Time",
            "Termination meeting",
            "Cry about life at home"
    );
    ObservableList<String> ListOfMonths = FXCollections.observableArrayList();
    ObservableList<LocalTime> PossibleStartTimesList = FXCollections.observableArrayList(GeneralFunctions.getStartTimes());
    ObservableList<LocalTime> PossibleEndTimesList = FXCollections.observableArrayList(GeneralFunctions.getStartTimes());
    ObservableList<Appointments> weeklist = FXCollections.observableArrayList();
    ObservableList<Appointments> monthlist = FXCollections.observableArrayList();


    /**
     * Initialize method.
     * This contains a lambda function for a listener to populate the fields to the left of the tableview
     * depending on what is selected by the user. It also initializes the scene, populates the tables, executes the initial queries, creates lists.
     * @throws SQLException sql exception.
     */
    public void initialize() throws SQLException {

        MainAppointmentTable.getItems().clear();
        AppointmentsDao.apptoblist.clear();
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

        ContactDao.contactNameList.clear();
        ContactDao.getContactNameList();
        MainContactNameCombo.setItems(ContactDao.contactNameList);

        MainTypeCombo.setItems(TypeComboList);
        MainTypeComboReport.setItems(TypeComboList);
        MainTypeComboReport1.setItems(TypeComboList);
        MainStartTimeCombo.setItems(PossibleStartTimesList);
        MainEndTimeCombo.setItems(PossibleEndTimesList);

        CustomerDAO.customerIDist.clear();
        CustomerDAO.getCustomerIdList();
        MainCustomerIdCombo.setItems(CustomerDAO.customerIDist);

        UserDao.userIDist.clear();
        UserDao.getUserIdList();
        MainUserIdCombo.setItems(UserDao.userIDist);
        MainReportTwoUserIdCombo.getItems().clear();
        MainReportTwoUserIdCombo.setItems(UserDao.userIDist);



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

        for (Appointments appt : AppointmentsDao.apptoblist) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
            LocalDate ld = LocalDate.parse(appt.getStart(), df);
            ListOfMonths.add(String.valueOf(ld.getMonth()));
            if (GeneralFunctions.checkMonth(appt.getStart())) {
                monthlist.add(appt);
                if (GeneralFunctions.checkWeek(appt.getStart())) {
                    weeklist.add(appt);
                }
            }
        }

        MainMonthComboReport.setItems(ListOfMonths);
    }

    /**
     * This function opens the Contact Schedule form.
     * @param event loads the contact schedule form if button is pressed.
     * @throws IOException i/o exception
     */
    public void MainOpenContactSchedule(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/ContactSchedule.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene contactSchedule = new Scene(root);
        stage.setScene(contactSchedule);
        stage.show();
    }
    /**
     * This function opens the Customer form.
     * @param event loads the contact schedule form if button is pressed.
     * @throws IOException i/o exception
     */
    public void MainOpenCustomer(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/CustomerForm.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene contactSchedule = new Scene(root);
        stage.setScene(contactSchedule);
        stage.show();
    }

    /**
     * Exit Application function.
     * this function closes the application scene.
     */
    public void exitApplication() {
        stage = (Stage) MainScenePane.getScene().getWindow();
        stage.close();
    }

    /**
     * The Save function is executed upon pressing the save button.
     * The function creates an object of the appointment to add, assigning values from the collected Fields.
     * It calls general functions from the utilities package, to ensure input data is validated. It will then call
     * upon the DOA package functions to save the appointment to the database after validation is performed, else it will
     * throw error messages as it catches exceptions.
     */
    public void SaveBtnPress() {
        try {
            int selectedappointmentId = MainAppointmentTable.getSelectionModel().selectedItemProperty().getValue().getAppointmentId();
            int apptIdField = Integer.parseInt(MainAppointmentId.getText());

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

            if (endTime.isAfter(startTime)) {
                if (((GeneralFunctions.DoesOverlap(startTime, endTime, date, apptToAdd.getCustomerId())) == -1) || selectedappointmentId == apptIdField){
                    if (Objects.equals(MainAppointmentId.getText(), "Auto-Generated")) {

                        int rowsAffected = AppointmentsDao.addNewAppt(apptToAdd);

                        if (rowsAffected > 0) {
                            GeneralFunctions.successMessage("Appointment Added", "The appointment has been successfully added");
                            MainAppointmentTable.getItems().clear();
                            AppointmentsDao.pullAppointments();
                            MainAppointmentTable.setItems(AppointmentsDao.apptoblist);

                        } else {
                            GeneralFunctions.alertError("Failed", "Appointment not added, check fields for errors");
                        }
                    } else {
                        apptToAdd.setAppointmentId(Integer.parseInt(MainAppointmentId.getText()));
                        int rowsAffected = AppointmentsDao.updateAppt(apptToAdd);
                        if (rowsAffected > 0) {
                            GeneralFunctions.successMessage("Appointment Updated", "Appointment " + apptToAdd.getAppointmentId() + " was updated Successfully");
                            MainAppointmentTable.getItems().clear();
                            AppointmentsDao.pullAppointments();
                            MainAppointmentTable.setItems(AppointmentsDao.apptoblist);
                        }
                    }
                } else {
                    GeneralFunctions.alertError("Appointment Time Conflict", "Selected Appointment times overlap with appointment: " +
                            (GeneralFunctions.DoesOverlap(startTime, endTime, date, apptToAdd.getCustomerId())));
                }
            } else {
                GeneralFunctions.alertError("End time before start time", "Please ensure the appointment end time is at least 15min after the start time");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            GeneralFunctions.alertError("Fields are empty", "Please ensure all fields have content");
        } catch (NumberFormatException e){
            GeneralFunctions.alertError("Please click 'Add New Appointment' button", "User must generate new appointment ID by clicking the 'Add New Appointment' button before trying to save the appointment");
        }
    }

    /**
     * The addNewAppoint function.
     * This function clears the contents of the text fields and sections to allow the user to enter new values for an appointment.
     * It also sets the text field of the appointment ID to a string which is tracked in the save button function to determine whether or not
     * the saved appoint is an update function call or a insert into call.
     */
    public void addNewAppointment() {
        MainAppointmentTable.getSelectionModel().clearSelection();
        MainAppointmentId.setText("Auto-Generated");
        MainTitle.clear();
        MainLocation.clear();
        MainDescription.clear();
        MainTypeCombo.valueProperty().set(null);
        MaineDatePicker.valueProperty().set(null);
        MainStartTimeCombo.valueProperty().set(null);
        MainEndTimeCombo.valueProperty().set(null);
        MainCustomerIdCombo.valueProperty().set(null);
        ;
        MainUserIdCombo.valueProperty().set(null);
        ;
        MainContactNameCombo.valueProperty().set(null);
        ;
    }

    /**
     * the Delete Appointment Function.
     * This function provides some validation that an appointment to delete exists, it then
     * defines what that appointment is by ID, gather's user input on an alert to confirm the appoint to be deleted,
     * and throws alerts depending on the success of the deletion.
     * @throws SQLException SQL exception if there is problem with delete.
     */
    public void DeleteAppt() throws SQLException {
        if ((MainAppointmentId.getText().equals("")) || MainAppointmentId.getText().equals("Auto-Generated")) {
            GeneralFunctions.alertError("No appointment selected", "Please select appointment from table to delete");
        } else {
            Appointments apptToDelete = new Appointments();
            apptToDelete.setAppointmentId(Integer.parseInt(MainAppointmentId.getText()));
            int tempid = apptToDelete.getAppointmentId();
            if (GeneralFunctions.confirmationMessage("Confirm Delete", "Appointment will be deleted",
                    "Confirm you want to delete appointment with ID of " + tempid)) {
                int rowsAffected = AppointmentsDao.deleteAppt(tempid);
                if (rowsAffected > 0) {
                    GeneralFunctions.successMessage("Appointment Deleted", "Appointment " + tempid + " has been successfully deleted");
                    MainAppointmentTable.getItems().clear();
                    AppointmentsDao.pullAppointments();
                    MainAppointmentTable.setItems(AppointmentsDao.apptoblist);
                } else {
                    GeneralFunctions.alertError("Failed", "Appointment was not deleted");
                }
            }
        }
    }

    /**
     * Get Results function One.
     * This function is for the first report generation handling.
     * It gathers the user selections from the combo box, looks through list of appointments for matches
     * and returns those matches to the text field.
     */
    public void getResultsReport1(){
        int count = 0;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
        String selectedmonth = MainMonthComboReport.getValue();
        String selecttype = MainTypeComboReport.getValue();
        for(Appointments appt: AppointmentsDao.apptoblist){
            LocalDate ld = LocalDate.parse(appt.getStart(), df);
            String month = String.valueOf(ld.getMonth());
            if(selectedmonth.equals(month) && (selecttype.equals(appt.getType()))){
                count ++;
            }
        }
        MainReportOneMatchingField.setText(String.valueOf(count));
    }
    /**
     * Get Results function Two.
     * This function is for the first report generation handling.
     * It gathers the user selections from the combo box, looks through list of appointments for matches
     * and returns those matches to the text field.
     */
    public void getResultsReport2() {
        int count = 0;
        for (Appointments appt : AppointmentsDao.apptoblist) {
            if ((MainReportTwoUserIdCombo.getValue() == appt.getUserID()) && (MainTypeComboReport1.getValue().equals(appt.getType()))) {
                count++;
            }
        }
        MainReportTwoMatchingField.setText(String.valueOf(count));
    }
}





