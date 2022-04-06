package Model;

/**
 * Contact Class
 */
public class Contact {
    private long contactID;
    private String contactName;

    /**
     * Constructor for the contact.
     *
     * @param contactID   the contact id
     * @param contactName the contact name
     */
    public Contact(long contactID, String contactName) {
        this.contactID = contactID;
        this.contactName = contactName;
    }
}

