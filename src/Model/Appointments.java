package Model;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * Appointment class
 */
public class Appointments {
    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private String type;
    private Timestamp start;
    private Timestamp end;
    private int customerId;
    private int userID;
    private int contactId;
    private Date date;
    //private ObservableList<Appointments> oblist = FXCollections.observableArrayList();
/**
     * Appointment class constructor
     * @param appointmentId the appointmentID
     * @param title the appointment title
     * @param description the appointment description
     * @param location the appointment location
     * @param type the appointment type
     * @param start the appointment start time
     * @param end the appointment end time
     * @param customerId the customer id
     * @param userID the user id
     * @param contactId the contact id
     */
    public Appointments(int appointmentId, String title, String description, String location, String type, Timestamp start, Timestamp end, int customerId, int userID, int contactId, Date date) {
        this.appointmentId = appointmentId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.customerId = customerId;
        this.userID = userID;
        this.contactId = contactId;
    }

    /**
     *
     * @return the appointment id
     */
    public int getAppointmentId() {
        return appointmentId;
    }

    /**
     *
     * @param appointmentId the appointment id of the meeting
     */
    public  void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title the title of the appointment
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description the description of the appointment
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location the location of the appointment
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type the type of the appointment
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return the start time
     */
    public Timestamp getStart() {
        return start;
    }

    /**
     *
     * @param start the start time of the appointment
     */
    public void setStart(Timestamp start) {
        this.start = start;
    }

    /**
     *
     * @return the end
     */
    public Timestamp getEnd() {
        return end;
    }

    /**
     *
     * @param end the end time of the appointment
     */
    public void setEnd(Timestamp end) {
        this.end = end;
    }

    /**
     *
     * @return the customer ID
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     *
     * @param customerId the customer id of the appointment
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     *
     * @return the user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @param userID the user ID of the appointment
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     *
     * @return the contact ID
     */
    public int getContactId() {
        return contactId;
    }

    /**
     *
     * @param contactId the contact ID of the appointment
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

  /*  public ObservableList<Appointments> getOblist() {
        return oblist;
    }*/
}

