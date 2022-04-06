package Model;

import java.sql.Date;

/**
 * Appointment class
 */
public class Appointments {
    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private String type;
    private String start;
    private String end;
    private int customerId;
    private int userID;
    private int contactId;
    private Date date;
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
    public Appointments(int appointmentId, String title, String description, String location, String type, String start, String end, int customerId, int userID, int contactId) {
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
     * Empty Appointments constructor.
     */
    public Appointments() {
    }

    /**
     * Getter for the ID of the appointment.
     * @return the appointment id
     */
    public int getAppointmentId() {
        return appointmentId;
    }

    /**
     * Setter for hte Id of the appointment.
     * @param appointmentId the appointment id of the meeting
     */
    public  void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * Getter for the title of the appointment.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for the title of the appointment.
     * @param title the title of the appointment
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for the description of the appointment.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the description of the appointment.
     * @param description the description of the appointment
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the location of the appointment.
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for the location of the appointment.
     * @param location the location of the appointment
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter for the type of the appointment.
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for the type of teh appointment.
     * @param type the type of the appointment
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for start datetime.
     * @return the start date time
     */
    public String getStart() {
        return start;
    }

    /**
     * Setter for start date time.
     * @param start the start of the appointment
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Getter for end datetime.
     * @return the end of the appointment
     */
    public String getEnd() {
        return end;
    }

    /**
     * Setter for end date time.
     * @param end the end of the appointment
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Getter for customer id.
     * @return the customer ID
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Setter for customer id.
     * @param customerId the customer id of the appointment
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter for user id.
     * @return the user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Setter for user id.
     * @param userID the user ID of the appointment
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Getter for contact id.
     * @return the contact ID
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * Setter for contact id.
     * @param contactId contact ID of the appointment
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

}

