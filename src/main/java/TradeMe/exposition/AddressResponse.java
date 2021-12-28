package TradeMe.exposition;

public class AddressResponse {

    public final String city;
    public final String number;
    public final  String street;

    public AddressResponse(String number,String street,String city) {
        this.number = number;
        this.city = city;
        this.street=street;
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