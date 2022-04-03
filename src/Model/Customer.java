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

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    /**]
     *
     * @return get the customer id
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     *
     * @param customerId sets customer id
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     *
     * @return gets the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     *
     * @param customerName sets the customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     *
     * @return get the customer Address
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     *
     * @param customerAddress set customer Address
     */
    public void setCustomAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     *
     * @return get customer Postal Code
     */
    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    /**
     *
     * @param customerPostalCode set customer postal code
     */
    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    /**
     *
     * @return get customer phone number
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     *
     * @param customerPhone set customer phone number
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     *
     * @return get customer division id
     */
    public int getCustomerDivisionId() {
        return customerDivisionId;
    }

    /**
     *
     * @param customerDivisionId set customer division ID
     */
    public void setCustomerDivisionId(int customerDivisionId) {
        this.customerDivisionId = customerDivisionId;
    }
}

