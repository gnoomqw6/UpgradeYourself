package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Skill implements Serializable{
    private String name;
    private Date startLearningDate;
    private Date endLearningDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getStartLearningDate() {
        return "Started: " + dateFormat.format(startLearningDate);
    }

    public void setStartLearningDate() {
        startLearningDate = new Date();
    }

    public String getEndLearningDate() {
        return "Finished: " + dateFormat.format(endLearningDate);
    }

    public void setEndLearningDate() {
        this.endLearningDate = new Date();
    }

    public String getLearningTime() {
        String result;
        if (endLearningDate != null) {
            long diff = endLearningDate.getTime() - startLearningDate.getTime();
            long learningTime = diff / 86400000;
            result = "Learning time: " + String.valueOf(learningTime) + " days";
        } else {
            long diff = new Date().getTime() - startLearningDate.getTime();
            long learningTime = diff / 86400000;
            result = "Learning time: " + String.valueOf(learningTime) + " days";
        }
        return result;
    }
}
