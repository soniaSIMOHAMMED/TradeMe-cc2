package TradeMe.domain;


import TradeMe.kernel.Entity;

import java.util.Objects;

public class User {
    private Id userId;
    private  String lastname;
    private  String firstname;
    private  int age;
    private Address address;
    private  String email;
    private String password;

    public User(Id userId, String lastname, String firstname, int age, Address address, String email, String password){
        this.userId = Objects.requireNonNull(userId);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.age = age;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public static User of(Id id, String lastname, String firstname, int age, Address address, String email, String password){
        return new User(id,lastname,firstname,age,address,email,password);
    }

    public Id getUserId() {return userId;}
    public String getLastname() {
        return lastname;
    }
    /*@Override
    public Id id(){
        return userId;
    }*/

    public String getFirstname() {
        return firstname;
    }
    public int getAge() { return age;}
    public Address getAddress() { return address;}
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    //public Id getMemberId() {return userId;}

    public void setUserId(Id userId) {
        this.userId = userId;
    }
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAddress(Address address) {this.address = address;}
    public void setEmail(String email) {this.email = email;}

    public void changePassword(String newPassword) {this.password = Objects.requireNonNull(newPassword);}
    public void changeAddress(Address newAddress) {this.address = Objects.requireNonNull(newAddress);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(userId, user.userId) && Objects.equals(lastname, user.lastname) && Objects.equals(firstname, user.firstname) && Objects.equals(address, user.address) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, lastname, firstname, age, address, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

