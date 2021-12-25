package TradeMe.domain;

import java.util.List;

public class Project {

    private final Id projectId;
    private final List<String> requiredSkills;
    private final List<Object> requiredTrades;
    private final Location location;
    private final int dailyRate;
    private final int periodOfEngagement;


    public Project(Id projectId, List<String> requiredSkills, List<Object> requiredTrades, Location location, int dailyRate, int periodOfEngagement) {
        this.projectId = projectId;
        this.requiredSkills = requiredSkills;
        this.requiredTrades = requiredTrades;
        this.location = location;
        this.dailyRate = dailyRate;
        this.periodOfEngagement = periodOfEngagement;
    }

    public Id getProjectId() {
        return projectId;
    }

    public Location getLocalisation() {
        return location;
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
                ", localisation=" + location +
                ", dailyRate=" + dailyRate +
                ", periodOfEngagement=" + periodOfEngagement +
                '}';
    }
}
