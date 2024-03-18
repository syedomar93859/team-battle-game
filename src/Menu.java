import javax.swing.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    public static final Scanner scanner;
    public static final ArrayList<String> options;
    private static String optMessage;

    public Menu() {
    }

    public static void menuLoop() {
        System.out.println(optMessage);
        String choice = scanner.nextLine();

        for (int option = Integer.parseInt(choice); option != 0; option = Integer.parseInt(choice)) {
            if (option > 0 && option < options.size()) {
                System.out.printf("Selected option %d, %s%n", option, options.get(option));
                System.out.println("Press any Enter key to continue");
                scanner.nextLine();
            }

            switch (option) {
                case 1:
                    createTeam();
                    break;

                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.printf("Option %d not recognizable%n", option);
            }

            System.out.println("Press any Enter key to see menu again");
            scanner.nextLine();
            System.out.println(optMessage);
            choice = scanner.nextLine();
        }

        System.out.println("Thank you for playing!");
    }

    static {
        scanner = new Scanner(System.in);
        options = new ArrayList();
        options.add("Exit");
        options.add("Create Team");
        options.add("Manage Team");
        options.add("About Members");
        optMessage = " \n\n Store and access details of the options and actions of the members in the party and also details about foe.\n \tMenu Options\n";
        StringBuilder sb = new StringBuilder();
        sb.append(optMessage);

        for (int i = 0; i < options.size(); ++i) {
            sb.append(String.format("\t%d. %s\n", i, options.get(i)));
        }

        optMessage = sb.toString();
    }

    public static void createTeam() {
        if (!existingTeam()) {
            //initialize new team within an arrayList
        } else {
            System.out.println("Error, there is already an existing team. Press enter to return back to menu");
            scanner.nextLine();
        }

    }

    public static boolean existingTeam() {
        //there is an existing team return true or return false
        return false;
    }


    public static void ManageTeamMenu() {
        System.out.println("1. Create New Character");
        System.out.println("2. Remove Character");
        System.out.println("3. Edit Current Character");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                addCharacter();
                break;

            case 2:
                removeCharacter();
                break;

            case 3:
                editCurrentCharacter();
                break;
        }

    }


    public static void addCharacter() {
        if (!filledTeams())
        {
            System.out.println("Pick a character to add:");
            System.out.println("1. Healer");
            System.out.println("2. Marksman");
            System.out.println("3. Swordsman");
            System.out.println("4. ShieldUser");
            int characterOption = scanner.nextInt();
            if (!CheckCharacter(characterOption))
            {
                //add character here
                System.out.println("Success! Member has been added.");
                scanner.nextLine();
            }
            else
            {
                System.out.println("Member already exists. Please enter to return back to menu.");
                scanner.nextLine();
            }
        }
        else
        {
            System.out.println("Error, team is full. Press enter to return back to menu");
            scanner.nextLine();
        }
    }

    public static boolean filledTeams() {
        //if the team is filled (member number equal to 4) then return true else return false
        return false;
    }


    public static void removeCharacter() {
        System.out.println("1. Healer");
        System.out.println("2. Marksman");
        System.out.println("3. Swordsman");
        System.out.println("4. ShieldUser");
        int option = scanner.nextInt();
        if (CheckCharacter(option))
        {
            // removeCharacter()
        }
        else {
            System.out.println("Error, there is no healer in current team");
        }
    }


    public static void editCurrentCharacter() {
        System.out.println("Pick a character to edit:");
        System.out.println("1. Healer");
        System.out.println("2. Marksman");
        System.out.println("3. Swordsman");
        System.out.println("4. ShieldUser");
        int characterOption = scanner.nextInt();

        if (CheckCharacter(characterOption))
        {
            System.out.println("Pick what to add:");
            System.out.println("1. add atk");
            System.out.println("2. add hp");
            System.out.println("3. add defense");
            int addOption = scanner.nextInt();
        }
    }


    public static void add(int addOption)
    {

    }



    public static boolean CheckCharacter (int option)
    {
        switch (option) {
            case 1:
                // check if there is a Healer in team already
                return true;
            case 2:
                // check if there is a Marksman in team already
                return true;
            case 3:
                // check if there is a Swordsman in team already
                return true;
            case 4:
                // check if there is a ShieldUser in team already
                return true;
        }
        return false;
    }
}



