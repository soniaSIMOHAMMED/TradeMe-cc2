package TradeMe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class User{
    @JsonIgnore
    private Id id;

    private  String lastname;
    private  String firstname;
    private  int age;
    //private Location location;
    private  String email;
    private String password;

    public User(Id id, String lastname, String firstname, int age, String email, String password/*, Location location*/){
        this.id = Objects.requireNonNull(id);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.age = age;
        //this.location = location;
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    public Id getUserId() {return id;}

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getAge() { return age;}

    public String getEmail() {
        return email;
    }

    //public Location getAddress() { return location;}

    public String getPassword() {
        return password;
    }

    public Id getMemberId() {return id;}

    public void setId(Id id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*public void setLocation(Location location) {
        this.location = location;
    }*/


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }
}

