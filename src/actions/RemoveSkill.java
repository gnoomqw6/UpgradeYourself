package actions;

import model.AllSkills;
import model.Skill;
import runOperations.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class RemoveSkill {
    private static AllSkills allSkills = Main.allSkills;
    private static String choice;
    private static List<Skill> list;

    public static void run(BufferedReader reader) throws IOException {
        System.out.println("\nWhat kind of skill do you want to remove?");
        System.out.println("\t0 - future skill");
        System.out.println("\t1 - skill in progress");
        System.out.println("\t2 - completed skill");
        System.out.print("\nPlease enter your choice: ");
        choice = reader.readLine();

        switch (choice) {
            case "0":
                list = allSkills.getFutureSkills();
                break;
            case "1":
                list = allSkills.getSkillInProgress();
                break;
            case "2":
                list = allSkills.getCompletedSkills();
                break;
            default:
                System.out.println("\nIncorrect input.");
                return;
        }

        removeFromSelectedList(list, reader);
    }

    private static void removeFromSelectedList(List<Skill> list, BufferedReader reader) throws IOException {
        if (list.isEmpty()) {
            System.out.println("\nSkill list is empty!");
        } else {
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                System.out.println("\t" + i + " - " + list.get(i).getName());
            }
            System.out.print("\nPlease enter your choice: ");
            choice = reader.readLine();
            try {
                int num = Integer.parseInt(choice);
                String skillToDelete = list.get(num).getName();
                System.out.print("\nAre you shure want to delete '" + skillToDelete + "'? [y/n]: ");
                choice = reader.readLine();
                System.out.println();
                if (choice.equalsIgnoreCase("y")) {
                    list.remove(num);       //TODO chek allskills is empty
                    System.out.println("\n" + skillToDelete + " was removed successfully.");
                } else if (choice.equalsIgnoreCase("n")) {
                    System.out.println("\nOperation aborted.");
                } else {
                    System.out.println("\nIncorrect input.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nIncorrect input!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\nIncorrect input!");
            }
        }
    }
}
