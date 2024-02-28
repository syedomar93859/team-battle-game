import java.util.Scanner;
import java.util.ArrayList;
public class Menu {
    public static final Scanner scanner = new Scanner(System.in);

    public static final ArrayList<String> options = new ArrayList<>();

    static {
        options.add("Exit");
        options.add("Choose Attack");
        options.add("Choose Run");
        options.add("Choose Assist");
        options.add("About Members");
    }

    //The method below is the intro message that shows up above the menu.
    private static String optMessage = """
           \s
                        
            Store and access details of the options and actions of the members in the party and also details about foe.
            \tMenu Options
            """;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(optMessage);
        for (int i = 0; i < options.size(); i++) {
            sb.append(String.format("\t%d. %s\n", i, options.get(i)));
        }
        optMessage = sb.toString();
    }

    public static void menuLoop() {
        System.out.println(optMessage);
        String choice = scanner.nextLine();
        int option = Integer.parseInt(choice);
        while (option != 0) {
            if (option > 0 && option < options.size()) {
                System.out.printf("Selected option %d, %s%n", option, options.get(option));
                System.out.println("Press any Enter key to continue");
                scanner.nextLine();
            }
            // switch case to prompt user to input option chosen
            switch (option) {
                case 1 -> menuEnterChooseAttack();
                case 2 -> menuEnterChooseRun();
                case 3 -> menuEnterChooseAssist();
                case 4 -> menuAboutMembers();
                default -> System.out.printf("Option %d not recognizable%n", option);
            }
            System.out.println("Press any Enter key to see menu again");
            scanner.nextLine();
            System.out.println(optMessage);
            choice = scanner.nextLine();
            option = Integer.parseInt(choice);
        }
        System.out.println("Thank you for playing!");
    }


    /**
     * used to display description about each member
     *
     */
    private static void menuAboutMembers() {
        int count = 0;
        System.out.println("1.Potioneer");
        System.out.println(Data.AboutMembers(1));
        System.out.println("2.Swordsman");
        System.out.println(Data.AboutMembers(2));
        System.out.println("3.Shield User");
        System.out.println(Data.AboutMembers(1));
    }

    /**
     * Used to stats of each member
     *
     */
    private static void menuEnterDisplayStats() {
        System.out.println(Data.displayStat("Potioneer"));
        System.out.println(Data.displayStat("Swordsman"));
        System.out.println(Data.displayStat("Shield User"));
        System.out.println("------------------------------------------");

    }



    /**
     * Used to choose assist on member
     *
     */
    private static void menuEnterChooseAssist() {
        menuEnterDisplayStats();
        boolean success = false;
        while (!success) {
            System.out.println("Enter the member to assist:");
            String member = scanner.nextLine();
            System.out.println();
            System.out.println("Enter the attack type:");
            int attack = Integer.parseInt(scanner.nextLine());
            if (validateMember(member) && validateAttack(attack))
            {
                success = Data.storeAssist(member, attack);
            }
            else
            {
                System.out.println("Error: please enter valid member and attack. Please press enter and try again.");
                System.out.println();
            }
        }
    }


    /**
     * Used to choose a member to run
     *
     */
    private static void menuEnterChooseRun() {
        menuEnterDisplayStats();
        boolean success = false;
        while (!success) {
            System.out.println("Enter the member to run:");
            String member = scanner.nextLine();
            if (validateMember(member)) {
                boolean runSuccess = Data.storeRun(member,0);
                success = runSuccess;
                System.out.printf("Run success: %b%n", runSuccess);
            }
            else {
                System.out.println("Error: please enter valid member. Please press enter and try again.");
                System.out.println();
            }

        }
    }

    /**
     * Used to choose member and attack
     *
     */
    private static void menuEnterChooseAttack()
    {
        menuEnterDisplayStats();
        boolean success = false;
        String member;
        while (!success)
        {
            System.out.println("Enter the member and attack type:");
            member = scanner.nextLine();
            int attackType = Integer.parseInt(scanner.nextLine());
            if (validateMember(member) && validateAttack(attackType))
            {
                success = Data.storeAttack(member, attackType);
                System.out.println(success);
                System.out.println();
            }
            else
            {
                System.out.println("Error: please enter valid member and attack. Please press enter and try again.");
                System.out.println();
            }
        }
    }

    /**
     * Used to validate user input of attack
     *
     * @param attack the  number the user has input which corresponds to the attack type
     * @return true if input is valid
     */
    private static boolean validateAttack(int attack) {
        if (attack == 1 || attack == 2 || attack == 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Used to validate user input of attack
     *
     * @param member the  number the user has input which corresponds to the attack type
     * @return true if input is valid
     */
    private static boolean validateMember(String member) {
        if (member.equals("Potioneer") || member.equals("Swordsman") || member.equals("Shield User")) {
            return true;
        } else {
            return false;
        }
    }
}


