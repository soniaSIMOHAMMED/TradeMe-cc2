package trademe.domain;

import java.util.List;

public final class Project {

    private final Id projectId;
    private final List<String> requiredSkills;
    private final List<Object> requiredTrades;
    private final Address address;
    private final int dailyRate;
    private final int periodOfEngagement;


    public Project(Id projectId, List<String> requiredSkills, List<Object> requiredTrades, Address address, int dailyRate, int periodOfEngagement) {
        this.projectId = projectId;
        this.requiredSkills = requiredSkills;
        this.requiredTrades = requiredTrades;
        this.address = address;
        this.dailyRate = dailyRate;
        this.periodOfEngagement = periodOfEngagement;
    }

    public Id getProjectId() {
        return projectId;
    }

    public Address getLocalisation() {
        return address;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public int getPeriodOfEngagement() {
        return periodOfEngagement;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public List<Object> getRequiredTrades() {
        return requiredTrades;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", requiredSkills=" + requiredSkills +
                ", requiredTrades=" + requiredTrades +
                ", localisation=" + address +
                ", dailyRate=" + dailyRate +
                ", periodOfEngagement=" + periodOfEngagement +
                '}';
    }
}
