package trademe.domain;

import java.util.HashMap;
import java.util.List;

public final class Tradesman {

    private final String trade;
    private List<String> skills;
    private HashMap<String, List<String>> disponibility;
    private int dailyRate;
    private Id userId;
    private  String lastname;
    private  String firstname;
    private  int age;
    private Address address;
    private  String email;
    private String password;


    public Tradesman(String trade, List<String> skills, HashMap<String, List<String>> disponibility, int dailyRate, Id userId, String lastname, String firstname, int age, Address address, String email, String password) {
        this.trade = trade;
        this.skills = skills;
        this.disponibility = disponibility;
        this.dailyRate = dailyRate;
        this.userId = userId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public Tradesman(Id userId,String trade) {
        this.userId = userId;
        this.trade = trade;

    }


    public String getTrade() {
        return trade;
    }

    public HashMap<String, List<String>> getDisponibility() {
        return disponibility;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "tradesman{" +
                "trade=" + trade +
                ", skills=" + skills +
                ", disponibility=" + disponibility +
                ", dailyRate=" + dailyRate +
                '}';
    }
}
