package Utilities;

import DAO.AppointmentsDao;
import DAO.DBConnection;
import DAO.DivisionDAO;
import Model.Appointments;
import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

/**
 * General function interface declaration
 */
public interface GeneralFunctions {
    ZoneId utcZoneId = ZoneId.of("UTC");
    ZoneId myZoneId = ZoneId.systemDefault();
    LocalDateTime userDateTime = LocalDateTime.now(myZoneId);
    LocalDate userDate = LocalDate.now(myZoneId);

    /**
     * Alert Error function.
     * This function takes a generic string for a title, and a generic string for a header and shows an alert with that text as an error message
     * @param Title title to show
     * @param Header header to show
     */
    static void alertError(String Title, String Header) {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle(Title);
        error.setHeaderText(Header);
        error.show();
    }
    /**
     * Alert Error function.
     * This function takes a generic string for a title, and a generic string for a header and shows an alert with that text as a success message
     * @param Title title to show
     * @param Header header to show
     */
    static void successMessage(String Title, String Header) {
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle(Title);
        success.setHeaderText(Header);
        success.show();
    }

    /**
     * Confirmation Message function.
     * This function passes 3 strings, title, header, and context and generates
     * a confirmation message to the user, returning true if the user selects true,
     * and false if the user selects no or cancel.
     * @param title title to show
     * @param header header to show
     * @param context context to show
     * @return true if okay false if cancel
     */
    static boolean confirmationMessage(String title, String header, String context) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle(title);
        confirmation.setHeaderText(header);
        confirmation.setContentText(context);

        Optional<ButtonType> btn = confirmation.showAndWait();
        if (btn.isPresent()) {
            if (btn.get() == ButtonType.OK) {
                return true;
            } else if (btn.get() == ButtonType.CANCEL) {
                return false;
            }
        }
        return false;
    }

    /**
     * Get start times function.
     * This function gets the user time zone offset from the business hours,
     * it then generates a list of times in 15 min increments for the hours the user
     * could schedule the appointment in their local time zone, as a reference to the business hours in est time zone.
     * @return the list of times the user can schedule the appointment during normal business hours.
     */
    static List<LocalTime> getStartTimes() {
        Integer userOffset = myZoneId.getRules().getOffset(Instant.now()).getTotalSeconds();
        ZoneId business = ZoneId.of("America/New_York");
        Integer businessOffset = business.getRules().getOffset(Instant.now()).getTotalSeconds();
        int diff = (businessOffset - userOffset) / 3600;

        String[] mins = {"00", "15", "30", "45"};
        List<LocalTime> times = new ArrayList<LocalTime>();

        for (int i = 8 - diff; i < 22 - diff; i++) {
            for (int j = 0; j < 4; j++) {
                String time = i + ":" + mins[j];
                if (i < 10) {
                    time = "0" + time;
                }
                times.add(LocalTime.parse(time));
            }
        }
        return (times);
    }

    /**
     * User time to UTC function.
     * This takes a date and time and converts to UTC time, the returns a string.
     * @param date entered date as a local date
     * @param time entered time as a local time
     * @return string of the entered date and time in UTC
     */
    static String UserTimeToUTC(LocalDate date, LocalTime time) {
        LocalDateTime ldt = LocalDateTime.of(date, time);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, myZoneId);
        ZonedDateTime utczdt = ZonedDateTime.ofInstant(zdt.toInstant(), utcZoneId);
        return (utczdt.toLocalDate().toString() + " " + utczdt.toLocalTime().toString());
    }

    /**
     * UTC Time to User Time function.
     * This function takes in a string (of UTC time) and converts it to the String of the same
     * UTC time but in the user's local time zone.
     * @param dbUTCTime Passed UTC time as a string
     * @return User time as a string.
     */
    static String UTCTimeToUserTime(String dbUTCTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(dbUTCTime, df);
        ZonedDateTime utczdt = ZonedDateTime.of(ldt, utcZoneId);
        ZonedDateTime myzdt = ZonedDateTime.ofInstant(utczdt.toInstant(), myZoneId);
        return (myzdt.toLocalDate().toString() + " " + myzdt.toLocalTime().toString());
    }

    /**
     * Date from DatePicker selection.
     * this function takes a string date value and converts it to a local date.
     * @param datetime passed date time as a string
     * @return localdate value
     */
    static LocalDate datePickerFromSelection(String datetime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
        LocalDateTime ldt = LocalDateTime.parse(datetime, df);
        return ldt.toLocalDate();
    }

    /**
     * Time from selection function.
     * This function takes a datetime value as a string and returns it as a local time.
     * @param datetime entered date time (string)
     * @return converted LocalTime
     */
    static LocalTime timeFromSelection(String datetime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
        LocalDateTime ldt = LocalDateTime.parse(datetime, df);
        return ldt.toLocalTime();
    }

    /**
     * Divisions from division list.
     * Lambda function
     * This function returns an Observable list of strings that consist of the Divisions in a particular country,
     * defined by a country name (String.)
     * @param countryName Entered country name
     * @return Observalbe list of divisions for that country.
     */
    static ObservableList<String> divisionsFromDivisionList(String countryName) {
        ObservableList<String> filteredList = FXCollections.observableArrayList();
        DivisionDAO.DivisionsList.forEach(Division -> {
            if (Objects.equals(Division.getCountryName(), countryName)) {
                filteredList.add(Division.getDivisionName());
            }
        });
        return filteredList;
    }

    /**
     * Get Division Id from input.
     * This function takes a country name and state/first level division and returns the divison ID.
     * @param countryName country name
     * @param state First level division
     * @return division ID
     */
    static int getDivIdFromInput(String countryName, String state) {
        for (Division div : DivisionDAO.DivisionsList) {
            if ((div.getCountryName().equals(countryName)) && (div.getDivisionName().equals(state))) {
                return div.getDivisionId();
            }
        }

        return -1;
    }

    /**
     * Check week function.
     * This function checks to see if the passed datetime (string) is within a week of the current user time.
     * @param datetime entered datetime as a string
     * @return true if date is within a week, false if not
     */
    static boolean checkWeek(String datetime) {
        LocalDate date = datePickerFromSelection(datetime);
        return ((date.isAfter(userDate) || date.isEqual(userDate)) && date.isBefore(userDate.plusWeeks(1)));
    }

    /**
     * Check month function.
     * This function checks to see if the passed datetime (string) is within a month of the current user time.
     * @param datetime entered datetime as a string
     * @return true if date is within a month, false if not
     */
    static boolean checkMonth(String datetime) {
        LocalDate date = datePickerFromSelection(datetime);
        return ((date.isAfter(userDate) || date.isEqual(userDate)) && date.isBefore(userDate.plusMonths(1)));
    }

    /**
     * Does overlap function.
     * This function checks to see if the appoint the user is trying to save overlaps with a time of another appointment for that customer
     * @param startTime start time of the appointment
     * @param endTime end time of the appointment
     * @param date date of the appointment
     * @param custId customer ID of who the appointment is with
     * @return appointment ID if date overlaps, otherwise -1
     */
    static int DoesOverlap(LocalTime startTime, LocalTime endTime, LocalDate date, int custId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
        LocalDateTime start = LocalDateTime.of(date, startTime);
        LocalDateTime end = LocalDateTime.of(date, endTime);
        for (Appointments appt : AppointmentsDao.apptoblist) {
            LocalDateTime exitingStart = LocalDateTime.parse(appt.getStart(), df);
            LocalDateTime existingEnd = LocalDateTime.parse(appt.getEnd(), df);
            LocalDate existingDate = exitingStart.toLocalDate();
            if (custId == appt.getCustomerId()) {
                if (date.isEqual(existingDate)) {
                    if (start.isAfter(exitingStart) && start.isBefore(existingEnd) || start.isEqual(exitingStart)) {
                        return appt.getAppointmentId();
                    }
                    if (end.isAfter(exitingStart) && end.isBefore(existingEnd) || end.isEqual(existingEnd)) {
                        return appt.getAppointmentId();
                    }
                }
            }

        }
        return -1;
    }

    /**
     * Check upcoming appointment function.
     * This function checks to see if there is an appointment within 15min of the user login time.
     * @return 1 if there is an appointment within 15min, -1 if there isn't
     * @throws SQLException SQLException
     */
    static int checkUpcomingAppt() throws SQLException {
        int check = -1;
        AppointmentsDao.apptoblist.clear();
        AppointmentsDao.pullAppointments();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
        LocalDateTime nowPlusFifteenMin =  userDateTime.plusMinutes(15);
        for (Appointments appt: AppointmentsDao.apptoblist){
            LocalDateTime exitingStart = LocalDateTime.parse(appt.getStart(), df);
            if(exitingStart.toLocalDate().isEqual(userDate)){
                if(exitingStart.isAfter(userDateTime) && exitingStart.isBefore(nowPlusFifteenMin)){
                    System.out.println(" there is an appointment within 15min");
                    int apptId = appt.getAppointmentId();
                    LocalDate date = datePickerFromSelection(appt.getStart());
                    LocalTime time = timeFromSelection(appt.getStart());
                    alertError("Upcoming or Current Appointment", "There is an appointment happening within 15min\n"+
                            "Appointment ID: " + apptId +
                            "\nDate: " + date +
                            "\nTime: " + time );
                    check =1;
                }
            }
            }
        return check;
    }
}
