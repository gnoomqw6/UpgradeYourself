package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AllSkills implements Serializable{
    private List<Skill> futureSkills;
    private List<Skill> completedSkills;
    private List<Skill> skillInProgress;
    public boolean isEmpty;

    public AllSkills() {
        futureSkills = new ArrayList<>();
        completedSkills = new ArrayList<>();
        skillInProgress = new ArrayList<>();
        isEmpty = true;
    }

    public List<Skill> getFutureSkills() {
        return futureSkills;
    }

    public void setFutureSkills(List<Skill> futureSkills) {
        this.futureSkills = futureSkills;
        isEmpty = false;
    }

    public List<Skill> getCompletedSkills() {
        return completedSkills;
    }

    public void setCompletedSkills(List<Skill> completedSkills) {
        this.completedSkills = completedSkills;
        isEmpty = false;
    }

    public List<Skill> getSkillInProgress() {
        return skillInProgress;
    }

    public void setSkillInProgress(List<Skill> skillInProgress) {
        this.skillInProgress = skillInProgress;
        isEmpty = false;
    }
}
