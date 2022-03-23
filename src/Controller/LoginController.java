package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
    private void AlertHandling(int num) {
        switch (num) {
            case 0:
                Alert partNotFound = new Alert(Alert.AlertType.ERROR);
                partNotFound.setTitle("Username not found");
                partNotFound.setHeaderText("Please check entered username for errors");
                partNotFound.show();
                break;
            case 1:
                Alert productNotFound = new Alert(Alert.AlertType.ERROR);
                productNotFound.setTitle("Password and username do not match");
                productNotFound.setHeaderText("Please retry username and password");
                productNotFound.show();
                break;
        }
    }
}




