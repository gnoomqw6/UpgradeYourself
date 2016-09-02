package actions;

import model.AllSkills;
import model.Skill;
import runOperations.Main;

import java.util.List;

public class ShowStatistic {
    private static AllSkills allSkills = Main.allSkills;

    public static void run() {
        if (allSkills == null || allSkills.isEmpty) {
            System.out.println("\nSorry, your skill list is empty. Please fill it.");
        } else {
            List<Skill> completedSkills = allSkills.getCompletedSkills();
            List<Skill> skillInProgress = allSkills.getSkillInProgress();
            List<Skill> futureSkills = allSkills.getFutureSkills();

            System.out.println("\nYour skills:");
            if (completedSkills.isEmpty()) {
                System.out.println("\tYou have no completed skills from the list!");
            } else {
                for (Skill skill: completedSkills) {
                    System.out.println("\t" + skill.getName());
                }
            }

            System.out.println("Skills in progress:");
            if (skillInProgress.isEmpty()) {
                System.out.println("\tYou have no skills in progress!");
            } else {
                for (Skill skill: skillInProgress) {
                    System.out.println("\t" + skill.getName());
                }
            }

            System.out.println("You have to learn skills:");
            if (futureSkills.isEmpty()) {
                System.out.println("\tYou know too much))");
            } else {
                for (Skill skill: futureSkills) {
                    System.out.println("\t" + skill.getName());
                }
            }
        }
    }
}
