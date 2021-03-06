package trademe.domain;

import java.util.Objects;

public final class Address {
    private  String number;
    private  String street;
    private  String city;

    public Address(String number, String street, String city) {
        this.number = number;
        this.street = Objects.requireNonNull(street);
        this.city = Objects.requireNonNull(city);
    }

    public static Address of(String number, String street, String city){
        return new Address(number,street,city);
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
