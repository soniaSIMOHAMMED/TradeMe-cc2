package TradeMe.domain;

import java.util.Objects;

public class Location {
    private  String number;
    private  String street;
    private  String city;

    public Location(String number, String street, String city) {
        this.number = number;
        this.street = Objects.requireNonNull(street);
        this.city = Objects.requireNonNull(city);
    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number=" + number +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
