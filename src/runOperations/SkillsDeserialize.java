package runOperations;

import model.AllSkills;
import model.Skill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class SkillsDeserialize {
    public static boolean fileIsEmpty = false;
    public static boolean noFile = false;
    public static AllSkills deserializeSkills() {
        AllSkills allSkills = new AllSkills();
        try (   FileInputStream fileInputStream = new FileInputStream("skills.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            allSkills.setFutureSkills((List<Skill>) objectInputStream.readObject());
            allSkills.setCompletedSkills((List<Skill>) objectInputStream.readObject());
            allSkills.setSkillInProgress((List<Skill>) objectInputStream.readObject());
            if (allSkills.getSkillInProgress().isEmpty() &&
                    allSkills.getFutureSkills().isEmpty() &&
                    allSkills.getCompletedSkills().isEmpty()) {
                fileIsEmpty = true;
                allSkills.isEmpty = true;
            } else {
                fileIsEmpty = false;
                noFile = false;
            }
        } catch (FileNotFoundException e) {
            noFile = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allSkills;
    }
}
