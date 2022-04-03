package Main;


import DAO.DBConnection;
import Model.Appointments;
import Utilities.GeneralFunctions;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class main extends Application {


    public static void main(String[] args) {
        DBConnection.openConnection();
        launch(args);
        DBConnection.closeConnection();
    }


    @Override
    public void start(Stage stage) throws Exception {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("Nat",currentLocale);
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("../View/LoginForm.fxml")),bundle);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
