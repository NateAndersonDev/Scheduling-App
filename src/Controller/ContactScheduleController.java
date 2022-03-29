package Controller;

import Model.Appointments;
import Model.Contact;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;

public class ContactScheduleController {

    @FXML
    private TableColumn<Appointments, Integer> ContactFormApptIdCol;

    @FXML
    private TableColumn<Appointments, Integer> ContactFormCustIdCol;

    @FXML
    private TableColumn<Appointments, Date> ContactFormDateCol;

    @FXML
    private TableColumn<Appointments, String> ContactFormDescriptionCol;

    @FXML
    private Button ContactFormExitButton;

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

    public void ReturnToMain(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Scheduler.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene MainFormScene = new Scene(root);
        stage.setScene(MainFormScene);
        stage.show();
    }

}
