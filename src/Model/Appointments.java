package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Time;


/**
 * Appointment class
 */
public class Appointments {
    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private String type;
    private Time start;
    private Time end;
    private int customerId;
    private int userID;
    private int contactId;
    private ObservableList<Appointments> apptlist = FXCollections.observableArrayList();

/*    *//**
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
     *//*
    public Appointments(int appointmentId, String title, String description, String location, String type, Time start, Time end, int customerId, int userID, int contactId) {
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
    }*/

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
    public void setAppointmentId(int appointmentId) {
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
    public Time getStart() {
        return start;
    }

    /**
     *
     * @param start the start time of the appointment
     */
    public void setStart(Time start) {
        this.start = start;
    }

    /**
     *
     * @return the end
     */
    public Time getEnd() {
        return end;
    }

    /**
     *
     * @param end the end time of the appointment
     */
    public void setEnd(Time end) {
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

    public ObservableList<Appointments> getApptlist() {
        return this.apptlist;
    }
}

