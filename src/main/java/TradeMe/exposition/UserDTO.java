package TradeMe.exposition;

import TradeMe.domain.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("all")
public class UserDTO {

    @JsonIgnore
    public  String userId;

    public  String lastname;
    public  String firstname;
    public  int age;
    public  AddressDTO address;
    public  String email;
    public  String password;

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId(){
        return this.userId;
    }


    public Id getId(){
        return Id.of(Integer.valueOf(userId));
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public AddressDTO getAddress(){
        return this.address;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}