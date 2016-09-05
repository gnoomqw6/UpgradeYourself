package actions;

import model.AllSkills;
import model.Skill;
import runOperations.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class MarkActiveAsCompleted {
    private static AllSkills allSkills = Main.allSkills;
    private static List<Skill> activeList = allSkills.getSkillInProgress();
    private static String choice;

    public static void run(BufferedReader reader) throws IOException {
        if (activeList.isEmpty()) {
            System.out.println("\nActive list is empty. Nothing to mark.");
        } else {
            System.out.println("Select skill to mark as completed.");
            for (int i = 0; i < activeList.size(); i++) {
                System.out.println("\t" + i + " - " + activeList.get(i).getName());
            }
            System.out.println("Please enter your choice: ");
            choice = reader.readLine();
            System.out.println();

            try {
                int num = Integer.parseInt(choice);
                Skill skill = activeList.get(num);
                skill.setEndLearningDate();
                allSkills.getCompletedSkills().add(skill);
                activeList.remove(num);
                System.out.println("\nSkill " + skill.getName() + " was marked as completed.");
            } catch (NumberFormatException e) {
                System.out.println("\nIncorrect input.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nIncorrect input.");
            }
        }
    }
}
