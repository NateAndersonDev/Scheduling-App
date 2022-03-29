package Model;

public class Countries {
    private int County_id;
    private String Country;

    public Countries(int county_id, String country) {
        County_id = county_id;
        Country = country;
    }

    public int getCounty_id() {
        return County_id;
    }

    public void setCounty_id(int county_id) {
        County_id = county_id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
