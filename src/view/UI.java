package view;

import actions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
    private static String enteredCommand;
    private static boolean exit = false;

    public static void firstStart() {
        System.out.println("\nHello, Sergey! You have no skills to learn.");
        System.out.println("Follow me to fill the skill list.");

        mainCycle();
    }

    public static void normalStart() {
        System.out.println("\nHello, Sergey! It's a nice day today to learn something new.");
        System.out.println("Here is your current statistic:\n");
        ShowStatistic.run();

        mainCycle();
    }

    private static void mainCycle() {
        try (   InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(inputStreamReader)) {
            while (!exit) {
                enteredCommand = askUser(reader);
                processChoice(enteredCommand, reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String askUser(BufferedReader reader) throws IOException {
        System.out.println("______________________________");
        System.out.println("\nYou can use commands below:");
        System.out.println("\t0 - show statistic");
        System.out.println("\t1 - add new skill");
        System.out.println("\t2 - remove skill");
        System.out.println("\t3 - mark skill as active");
        System.out.println("\t4 - mark active skill as completed");
        System.out.println("\t5 - exit the program");
        System.out.print("\nPlease enter your choice: ");
        return reader.readLine();
    }

    private static void processChoice(String choice, BufferedReader reader) throws IOException {
        switch (choice) {
            case "0":
                ShowStatistic.run();
                break;
            case "1":
                AddSkill.run(reader);
                break;
            case "2":
                RemoveSkill.run(reader);
                break;
            case "3":
                MarkFutureAsActive.run(reader);
                break;
            case "4":
                MarkActiveAsCompleted.run(reader);
                break;
            case "5":
                exit = true;
                break;
            default:
                System.out.println("incorrect choice");
        }
    }
}
