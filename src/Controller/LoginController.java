package Controller;

import DAO.UserDao;
import Model.User;
import Utilities.Logger;
import Utilities.GeneralFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Objects;

/**
 * Login controller class declaration
 */
public class LoginController {
    public Label FxError;
    private Stage stage;
    @FXML
    private AnchorPane MainScenePane;

        @FXML
        private TextField LoginPasswordField;

        @FXML
        private TextField LoginUserNameField;

        @FXML
        public Label ZoneIDField;


    public Button LoginFormLoginBTN;

    public Button LoginFormCancelBTN;

    /**
     * method to exit the application.
     * This method exits the application
     */
    public void exitApplication() {
        stage = (Stage) MainScenePane.getScene().getWindow();
        stage.close();
    }

    /**
     * View Scheduler function.
     * This function opens the scheduler scene.
     * @param event creates a new scheduler scene
     * @throws IOException IOException
     */
    void viewScheduler(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/Scheduler.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scheduler = new Scene(root);
        stage.setScene(scheduler);
        stage.show();
    }

    /**
     * Initializes the zone id text field.
     * Sets the error invisible.
     */
    public void initialize(){
        ZoneIDField.setText(ZoneId.systemDefault().getId());
        FxError.setVisible(false);
    }

    /**
     * Login button press function.
     * This function Checks for matching password and user name, writes to the log file, opens the main window, checks for appointments within 15 min, and generates messages if so.
     * @param event login button is pressed
     * @throws SQLException SQL Exception
     * @throws IOException IO exception
     */
    public void LoginBtnPress(ActionEvent event) throws SQLException, IOException {
        String userNM = LoginUserNameField.getText();
        String userPW = LoginPasswordField.getText();
        User user = new User(userNM,userPW);

        if(UserDao.checkValidUserName(user.getUserName())){
            if(UserDao.checkMatchPw(user.getUserName(),user.getPassword())){
                Logger.writeToLogSuccess(user.getUserName());
                viewScheduler(event);
                if(GeneralFunctions.checkUpcomingAppt() == -1) {
                    GeneralFunctions.alertError("No upcoming appointments", "There are no appointments within 15 min from now");
                }

            } else {
                FxError.setVisible(true);
            }
        } else {
            Logger.writeToLogFail(user.getUserName());
            FxError.setVisible(true);
        }
    }
}




