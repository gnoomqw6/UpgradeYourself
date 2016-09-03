package actions;

import model.AllSkills;
import model.Skill;
import runOperations.Main;

import java.io.BufferedReader;
import java.io.IOException;

public class AddSkill {
    private static AllSkills allSkills = Main.allSkills;
    private static String skillName;

    public static void run(BufferedReader reader) throws IOException {
        System.out.print("\nEnter name of the skill: ");
        skillName = reader.readLine().toUpperCase();
        System.out.println();
        allSkills.getFutureSkills().add(new Skill(skillName));
        allSkills.isEmpty = false;
        System.out.println("\nSkill '" + skillName + "' was added to the list.");
    }
}
