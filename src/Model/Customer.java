package Model;

/**
 * Customer class
 */
public class Customer {
    int customerId;
    String customerName;
    String customerAddress;
    String customerPostalCode;
    String customerPhone;
    int customerDivisionId;
    String country;
    String division;

    /**
     * Constructor for the customer object
     * @param customerId is the customer id
     * @param customerName is the customer Name
     * @param customerAddress is the customer Address
     * @param customerPostalCode is the customer's postal code
     * @param customerPhone is the customer's phone number
     * @param customerDivisionId is the customer's division ID
     */
    public Customer(int customerId, String customerName, String customerAddress, String customerPostalCode, String customerPhone, int customerDivisionId, String country, String division) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPostalCode = customerPostalCode;
        this.customerPhone = customerPhone;
        this.customerDivisionId = customerDivisionId;
        this.country = country;
        this.division = division;
    }

    /**
     * empty constructor.
     */
    public Customer() {
    }

    /**
     * getter for country.
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * getter for division.
     * @return division
     */
    public String getDivision() {
        return division;
    }


    /**
     * Getter for customer ID.
     * @return the customer id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Settter for customer ID.
     * @param customerId  customer id
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter for customer name.
     * @return gets the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Setter for customer name.
     * @param customerName the customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Getter for customer address.
     * @return get customer Address
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Setter for customer Address.
     * @param customerAddress customer Address
     */
    public void setCustomAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * Getter for customer postal code.
     * @return customer Postal Code
     */
    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    /**
     * Setter for customer postal code.
     * @param customerPostalCode customer postal code
     */
    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    /**
     * Getter for customer phone number.
     * @return customer phone number
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * Setter for customer phone number.
     * @param customerPhone customer phone number
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * Getter for customer division id.
     * @return customer division id
     */
    public int getCustomerDivisionId() {
        return customerDivisionId;
    }

    /**
     * Setter for customer division ID.
     * @param customerDivisionId customer division ID
     */
    public void setCustomerDivisionId(int customerDivisionId) {
        this.customerDivisionId = customerDivisionId;
    }
}

