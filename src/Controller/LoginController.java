package Controller;

import DAO.DBConnection;
import DAO.UserDao;
import Model.User;
import Utilities.GeneralFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import javax.swing.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Objects;

/**
 * the login controller
 */
public class LoginController {
    public Label FxError;
    private Stage stage;
    @FXML
    private AnchorPane MainScenePane;
    private Parent root;

        @FXML
        private TextField LoginPasswordField;

        @FXML
        private TextField LoginUserNameField;

        @FXML
        public Text FxUserName;

        @FXML
        public Label ZoneIDField;


    public Button LoginFormLoginBTN;

    public Button LoginFormCancelBTN;

    /**
     * method to exit the application
     * @param exitApp closes application
     */
    public void exitApplication(ActionEvent exitApp) {
        stage = (Stage) MainScenePane.getScene().getWindow();
        stage.close();
    }
    void viewScheduler(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/Scheduler.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scheduler = new Scene(root);
        stage.setScene(scheduler);
        stage.show();
    }
    public void initialize(){
        ZoneIDField.setText(ZoneId.systemDefault().getId());
        FxError.setVisible(false);
    }


    public void LoginBtnPress(ActionEvent event) throws SQLException, IOException {
        String userNM = LoginUserNameField.getText();
        String userPW = LoginPasswordField.getText();
        User user = new User(userNM,userPW);

        if(UserDao.checkValidUserName(user.getUserName())){
            if(UserDao.checkMatchPw(user.getUserName(),user.getPassword())){
                viewScheduler(event);
            } else {
                FxError.setVisible(true);
            }
        } else {
            FxError.setVisible(true);
        }
    }
}




