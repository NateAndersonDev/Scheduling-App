package Model;

public class DivisionId {
    int divisionId;
    String divisionName;
    int countryCode;

    public void Divisions(int divisionId, String divisionName, int CountryCode) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.countryCode = CountryCode;

    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
