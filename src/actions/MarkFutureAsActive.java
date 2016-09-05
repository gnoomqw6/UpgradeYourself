package actions;

import model.AllSkills;
import model.Skill;
import runOperations.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class MarkFutureAsActive {
    private static AllSkills allSkills = Main.allSkills;
    private static List<Skill> futureList = allSkills.getFutureSkills();
    private static String choice;

    public static void run(BufferedReader reader) throws IOException {
        if (futureList.isEmpty()) {
            System.out.println("\nFuture list is empty. Nothing to mark.");
        } else {
            System.out.println("Select skill to mark as active.");
            for (int i = 0; i < futureList.size(); i++) {
                System.out.println("\t" + i + " - " + futureList.get(i).getName());
            }
            System.out.println("Please enter your choice: ");
            choice = reader.readLine();
            System.out.println();

            try {
                int num = Integer.parseInt(choice);
                Skill skill = futureList.get(num);
                skill.setStartLearningDate();
                allSkills.getSkillInProgress().add(skill);
                futureList.remove(num);
                System.out.println("\nSkill " + skill.getName() + " was marked as active.");
            } catch (NumberFormatException e) {
                System.out.println("\nIncorrect input.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nIncorrect input.");
            }
        }
    }
}
