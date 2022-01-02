package trademe.domain;


import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class User {
    private Pattern pattern;
    private Id userId;
    private  String lastname;
    private  String firstname;
    private  int age;
    private Address address;
    private  String email;
    private String password;
    private Trade trade;

    public User(Id userId, String lastname, String firstname, int age, Address address, String email, String password){
        this.userId = Objects.requireNonNull(userId);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.age = age;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public User(Id userId, String lastname, String firstname, int age, Address address, String email, String password,Trade trade){
        this.userId = Objects.requireNonNull(userId);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.age = age;
        this.address = address;
        this.email = email;
        this.password = password;
        this.trade = trade;
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
    public void setTrade(String job){
        if(job== "Electrician"){this.trade = Trade.ELECTRICIAN;}
        if(job== "Mason"){this.trade = Trade.MASON;}
        if(job== "Plumber"){this.trade = Trade.PLUMBER;}
        if(job== "Carpenter"){this.trade = Trade.CARPENTER;}
    }
    public Trade getTrade(){
       return this.trade;
    }
    public Trade getTradeFromString(String job){
        if(job== "Electrician"){return Trade.ELECTRICIAN;}
        if(job== "Mason"){return Trade.MASON;}
        if(job== "Plumber"){return Trade.PLUMBER;}
        if(job== "Carpenter"){return Trade.CARPENTER;}
        return null;
    }

    public String getTradeString(Trade job){
        if(job== Trade.ELECTRICIAN){return "Electrician";}
        if(job== Trade.MASON){return "Mason";}
        if(job== Trade.PLUMBER){return "Plumber";}
        if(job== Trade.CARPENTER){return "Carpenter";}
        return null;
    }

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

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";



    public String checkAge(){
        return age>=18 ? "" : " * Your age doesn't allow you to be a Tradesman/Contractor :( ";
    }

    public String checkEmail(){
        boolean doesMatch;
        Matcher matcher;
        matcher = pattern.matcher(this.email);
        doesMatch = matcher.matches();

        return doesMatch ? "" : " * Please insert a valid Email ! ";

    }


    public boolean VerifyApplication(){

        String checkAge = checkAge();
        String checkEmail = checkEmail();
        return ((checkAge=="") && (checkEmail==""));

    }

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

