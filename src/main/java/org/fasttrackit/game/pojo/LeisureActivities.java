package org.fasttrackit.game.pojo;

public class LeisureActivities {
    private int id;
    private String activityName;
    private int changeMoodLevel;
    private int numberOfActivitiesRemaining;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getChangeMoodLevel() {
        return changeMoodLevel;
    }

    public void setChangeMoodLevel(int changeMoodLevel) {
        this.changeMoodLevel = changeMoodLevel;
    }

    public int getNumberOfActivitiesRemaining() {
        return numberOfActivitiesRemaining;
    }

    public void setNumberOfActivitiesRemaining(int numberOfActivitiesRemaining) {
        this.numberOfActivitiesRemaining = numberOfActivitiesRemaining;
    }

    public LeisureActivities(String activityName, int changeMoodLevel, int numberOfActivitiesRemaining) {
        this.activityName = activityName;
        this.changeMoodLevel = changeMoodLevel;
        this.numberOfActivitiesRemaining = numberOfActivitiesRemaining;
    }

    public LeisureActivities() {
    }
}
