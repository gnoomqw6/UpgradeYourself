package runOperations;

import model.AllSkills;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SkillsSerialize {
    public static void serializeSkills(AllSkills allSkills) {
        if (allSkills != null && !allSkills.isEmpty) {
            try (   FileOutputStream fileOutputStream = new FileOutputStream("skills.ser");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
                objectOutputStream.writeObject(allSkills.getFutureSkills());
                objectOutputStream.writeObject(allSkills.getCompletedSkills());
                objectOutputStream.writeObject(allSkills.getSkillInProgress());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
