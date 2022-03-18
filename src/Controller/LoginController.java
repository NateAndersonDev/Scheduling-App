package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class LoginController {
    private Stage stage;
    @FXML
    private AnchorPane MainScenePane;
    private Parent root;
    @FXML
        private Text LoginCurrentLocation;

        @FXML
        private TextField LoginPasswordField;

        @FXML
        private TextField LoginUserNameField;

    public TextField CurrentLocationTextField;

    public Button LoginFormLoginBTN;

    public Button LoginFormCancelBTN;

    public void exitApplication(ActionEvent exitApp) {
        stage = (Stage) MainScenePane.getScene().getWindow();
        stage.close();
    }
}




