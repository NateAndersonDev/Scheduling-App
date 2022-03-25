package Model;

/**
 * Contact Class
 */
public class Contact {
    private long contactID;
    private String contactName;

    /**
     *  Constructor for the contact.
     * @param contactID the contact id
     * @param contactName the contact name
     */
    public Contact(long contactID, String contactName) {
        this.contactID = contactID;
        this.contactName = contactName;
    }

    /**
     *
     * @return the contact id
     */
    public long getContactID() {
        return contactID;
    }

    /**
     *
     * @param contactID set the contact id
     */
    public void setContactID(long contactID) {
        this.contactID = contactID;
    }

    /**
     *
     * @return the contact name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     *
     * @param contactName set the contact name;
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}

