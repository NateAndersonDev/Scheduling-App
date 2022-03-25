package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

/**
 * the login controller
 */
public class LoginController {
    public Label FxError;
    public TextField FxZoneID;
    private Stage stage;
    @FXML
    private AnchorPane MainScenePane;
    private Parent root;


        @FXML
        private TextField FxZoneId;

        @FXML
        private TextField LoginPasswordField;

        @FXML
        private TextField LoginUserNameField;

        @FXML
        public Text FxUserName;



    public Button LoginFormLoginBTN;

    public Button LoginFormCancelBTN;

    /**
     * method to exit the application
     * @param exitApp
     */
    public void exitApplication(ActionEvent exitApp) {
        stage = (Stage) MainScenePane.getScene().getWindow();
        stage.close();
    }
}




