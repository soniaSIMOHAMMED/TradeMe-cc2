package trademe.domain;

import java.util.List;

public final class Contractor{

    private List<Project> projects;
    private Id userId;
    private  String lastname;
    private  String firstname;
    private  int age;
    private Address address;
    private  String email;
    private String password;
    public Contractor(Id id){
        this.userId=id;
    }

    public Contractor(List<Project> projects, Id userId, String lastname, String firstname, int age, Address address, String email, String password) {
        this.projects = projects;
        this.userId = userId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "serviceProvider{" +
                "projects=" + projects +
                '}';
    }
}
