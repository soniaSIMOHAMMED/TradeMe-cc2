package trademe.domain;

import java.util.List;
import java.util.Objects;

public final class Contractor extends User{

    private final List<Project> projects;

    public Contractor(Id userId, String lastname, String firstname, int age, Address address, String phoneNumber, String email, String password,List<Project> projects) {
        super(userId,lastname,firstname,age,address,phoneNumber,email,password);
        this.projects = projects;

    }

    public static Contractor of(Id userId, String lastname, String firstname, int age, Address address, String phoneNumber, String email, String password,List<Project> projects){
        return new Contractor(userId,lastname,firstname,age,address,phoneNumber,email,password,projects);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Contractor that = (Contractor) o;
        return Objects.equals(projects, that.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), projects);
    }

    @Override
    public String toString() {
        return "serviceProvider{" +
                "projects=" + projects +
                '}';
    }
}
