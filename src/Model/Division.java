package Model;

public class Division {
    String divisionName;
    String countryName;

    public Division(String divisionName, String countryName) {
        this.divisionName = divisionName;
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryName;
    }

    public void setCountryCode(String countryCode) {
        this.countryName = countryCode;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
