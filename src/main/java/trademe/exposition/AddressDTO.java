package trademe.exposition;

public final class AddressDTO {

    public String number;
    public String street;
    public String city;

    public AddressDTO(String number, String street, String city) {
        this.number = number;
        this.street = street;
        this.city = city;
    }

    public AddressDTO(){

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

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}