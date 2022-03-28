package Utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

/**
 * Alert utility functions.
 */
public class GeneralFunctions {
    /**
     * Passes in a title and header string to display them as an error.
     * @param Title title of the error
     * @param Header header of the error
     */
    public void alertError(String Title, String Header) {
        Alert general = new Alert(Alert.AlertType.ERROR);
        general.setTitle(Title);
        general.setHeaderText(Header);
        general.show();
    }
    public void returnToAppointments(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/MainForm.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene MainFormScene = new Scene(root);
        stage.setScene(MainFormScene);
        stage.show();
    }

    /*
    WRITE SOME FUNCTION TO GET CONTACT ID FROM CONTACT NAME
    public long getContactID(String contactName)
    }

    WRITE SOME FUNCTION TO GET CONTACT NAME FROM CONTACT ID

    Function that takes First and Second level country data and turn it into a Division ID & Vice Versa.

    Functions that converts between all the timezones. UTC -> Local, UTC -> Eastern, System -> UTC etc.
    This will save you lots of time and headache. Make these, test these and you will save the hardest part of your project.
    Use LocalDateTime objects and ZoneID’s to do this. There are resources online.
 */

}