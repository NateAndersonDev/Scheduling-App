package Model;

/**
 * Division class declaration.
 */
public class Division {
    String divisionName;
    String countryName;
    int divisionId;

    /**
     * Division constructor.
     * @param divisionName Division name
     * @param countryName Country Name
     * @param divisionId Division Id
     */
    public Division(String divisionName, String countryName, int divisionId) {
        this.divisionName = divisionName;
        this.countryName = countryName;
        this.divisionId = divisionId;
    }

    /**
     * Getter for Division Id.
     * @return division ID
     */
    public int getDivisionId() {
        return divisionId;
    }

    /**
     * getter for division name.
     * @return division name
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * Getter for country Name.
     * @return country name.
     */
    public String getCountryName() {
        return countryName;
    }

}
