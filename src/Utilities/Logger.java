package Utilities;

import java.io.*;
import java.sql.Timestamp;

/**
 * Logger class declaration.
 */
public class Logger {
    static int count = 0;

    /**
     * Create Log method.
     * Creates the "login_activity.txt" file.
     */
    public static void createLog(){
        try {
            File log = new File("login_activity.txt");
            log.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes log to file if successful.
     */
    public static void writeToLogSuccess() {
        try{
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        FileWriter writeLogin = new FileWriter("login_activity.txt",true);
            writeLogin.write("Login attempt #: " + count + "\n");
            writeLogin.write("Timestamp: " + stamp +"\n");
            writeLogin.write("Login Successful: True \n");
            writeLogin.write("\n");
            writeLogin.close();
            count ++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes log to file if login was not successful.
     */
    public static void writeToLogFail() {
        try {
            Timestamp stamp = new Timestamp(System.currentTimeMillis());
            FileWriter writeLogin = new FileWriter("login_activity.txt",true);
            writeLogin.write("Login attempt #: " + count +"\n");
            writeLogin.write("Timestamp: " + stamp+"\n");
            writeLogin.write("Login Successful: False \n");
            writeLogin.write("\n");
            writeLogin.close();
            count ++;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
