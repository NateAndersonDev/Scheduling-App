package Main;


import DAO.DBConnection;
import Utilities.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Main class declaration.
 */
public class main extends Application {

    /**
     * Main args function.
     * Creates the log, starts the DB connection and launches the application.
     * @param args arguments for the function.
     */
    public static void main(String[] args) {
        Logger.createLog();
        DBConnection.openConnection();
        launch(args);
        DBConnection.closeConnection();
    }

    /**
     * Start function.
     * This gets the resource bundle, determines language and gets the login form.
     * @param stage login form.
     * @throws Exception runtime exception
     */
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
