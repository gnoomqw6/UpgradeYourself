package model;

import java.io.Serializable;
import java.util.Date;

public class Skill implements Serializable{
    private String name;
    private Date startLearning;
    private Date endLearning;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartLearning() {
        return startLearning;
    }

    public void setStartLearning(Date startLearning) {
        this.startLearning = startLearning;
    }

    public Date getEndLearning() {
        return endLearning;
    }

    public void setEndLearning(Date endLearning) {
        this.endLearning = endLearning;
    }
}
