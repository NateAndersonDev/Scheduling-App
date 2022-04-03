package Model;

public class Countries {
    private int County_id;
    private String Country;

    public Countries(int country_id, String country) {
        County_id = country_id;
        Country = country;
    }

    public int getCountry_id() {
        return County_id;
    }

    public void setCountry_id(int county_id) {
        County_id = county_id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
