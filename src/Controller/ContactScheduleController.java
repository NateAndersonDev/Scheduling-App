package Controller;

import DAO.AppointmentsDao;
import DAO.ContactDao;
import Model.Appointments;
import Utilities.GeneralFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Objects;


/**
 * Contact Schedule Controller declaration.
 */
public class ContactScheduleController {

    @FXML
    private TableColumn<Appointments, Integer> ContactFormApptIdCol;

    @FXML
    private TableColumn<Appointments, Integer> ContactFormCustIdCol;

    @FXML
    private TableColumn<Appointments, String> ContactFormDescriptionCol;

    @FXML
    private ComboBox<String> ContactFormNameCombo;

    @FXML
    private TableColumn<Appointments, Time> ContactFormStartTimeCol;

    @FXML
    private TableView<Appointments> ContactFormTable;

    @FXML
    private TableColumn<Appointments, String> ContactFormTitleCol;

    @FXML
    private TableColumn<Appointments, String> ContactFormTypeCol;

    @FXML
    private TableColumn<Appointments, Time> ContractFromEndTimeCol;

    ObservableList<Appointments> matchingAppointments = FXCollections.observableArrayList();
    /**
     * Return to main function.
     * This function is executed upon button press to return the user to the main scheduler form.
     * @param event button press
     * @throws IOException I/o exception.
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
     * This sets the possible names in the contact box, and a listener in the box so if a user changes the contact after getting results it will clear the table.
     */
    public void initialize(){
        ContactFormNameCombo.setItems(ContactDao.contactNameList);
        ContactFormNameCombo.valueProperty().addListener((obs, oldValue, newValue) -> {
            if(!Objects.equals(oldValue, newValue)){
                matchingAppointments.clear();
            }
        });

    }

    /**
     * Get results function.
     * This executes if the get results button is pressed. It iterates through the list of appointments and if the appointment contains a matching
     * contact id to the contact name in the combo box it populates the table accordingly. Also contains validation to ensure the user has selected a contact
     * before pressing the get results button.
     * @throws SQLException SQL exception.
     */
    public void  getResults() throws SQLException {
        matchingAppointments.clear();
        ContactFormTable.getItems().clear();
        if(ContactFormNameCombo.getValue() != null) {
            for (Appointments appt : AppointmentsDao.apptoblist) {
                if (Objects.equals(ContactDao.getContactName(appt.getContactId()), ContactFormNameCombo.getValue())) {
                    matchingAppointments.add(appt);
                    ContactFormTable.setItems(matchingAppointments);
                    ContactFormApptIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
                    ContactFormTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
                    ContactFormTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
                    ContactFormDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
                    ContactFormStartTimeCol.setCellValueFactory(new PropertyValueFactory<>("start"));
                    ContractFromEndTimeCol.setCellValueFactory(new PropertyValueFactory<>("end"));
                    ContactFormCustIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
                }
            }
        } else{
            GeneralFunctions.alertError("No contact Selected", "Please select Contact Name and try again.");
        }

    }

}
