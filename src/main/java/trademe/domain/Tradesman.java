package trademe.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class Tradesman extends User{

    private final Trade trade;
    private List<String> skills;
    private HashMap<String, List<String>> disponibility;
    private int dailyRate;



    public Tradesman(Id userId, String lastname, String firstname, int age, Address address, String phoneNumber, String email, String password, Trade trade, List<String> skills, HashMap<String, List<String>> disponibility, int dailyRate) {
        super(userId,lastname,firstname,age,address,phoneNumber,email,password);
        this.trade = trade;
        this.skills = skills;
        this.disponibility = disponibility;
        this.dailyRate = dailyRate;

    }

    public static Tradesman of(Id userId, String lastname, String firstname, int age, Address address, String phoneNumber, String email, String password,Trade trade, List<String> skills, HashMap<String, List<String>> disponibility, int dailyRate){
        return new Tradesman(userId,lastname,firstname,age,address,phoneNumber,email,password,trade,skills,disponibility,dailyRate);
    }


    @Override
    public Trade getTrade() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tradesman tradesman = (Tradesman) o;
        return dailyRate == tradesman.dailyRate && trade == tradesman.trade && Objects.equals(skills, tradesman.skills) && Objects.equals(disponibility, tradesman.disponibility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trade, skills, disponibility, dailyRate);
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
