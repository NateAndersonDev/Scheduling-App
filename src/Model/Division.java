package Model;

public class Division {
    String divisionName;
    String countryName;
    int divisionId;

    public Division(String divisionName, String countryName, int divisionId) {
        this.divisionName = divisionName;
        this.countryName = countryName;
        this.divisionId = divisionId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
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
