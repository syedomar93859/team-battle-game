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
    }

    //The method below is the intro message that shows up above the menu.
    private static String optMessage = """
            Your team has entered an undiscovered cave entrance and goes inside to take a safe and short rest in the night. All of you have been travelling on a long voyage to seek wealth and power. Unknowingly, they just stepped into the domain of a long gone ancient king called Mammon. Demon King Mammon was a demon that caused calamities wherever it went, by cursing crowds of people and royalty with excessive greed and causing them to go insane. The number of people affected were in the millions and caused families and communities to dissolve. Fortunately, a mysterious hero came from lands far away had happen to come face to face with the beast. His presence lifted the cursed of anyone around him and his weapon, a sword that seemingly bursted out with holy power, cut the beast until no parts of it were left. The hero soon disappeared using magical means that were too advanced for anyone to comprehend, and kingdoms and villages were left to recover for the next century. It has been more than 500 years since the great demon was put to rest, and all the power of the kingdoms and nations had grown even stronger. Old tales remind explorers of the vast riches the demon left behind in its resting grounds that it collected from battlefields it never joined, but won regardless. Whether these tales were myths or not, did not stop hundreds of thousands of adventurers from searching for the ancient beast’s riches all throughout the land.The team of three knew about this story in the back of their mind, but never considered trying to find the grounds as it   seemed impossible for the fact that no-one has discovered such a place for centuries.\s
            They continued deeper into the cave, to eventually face a dead end and settle down. But before they had a chance, a black blob slowly creeped out from a small crevice at the ceiling of the bottom of the cave. The trio took their stances, ready to engage in a fight as the 8 feet tall and 8 feet wide black slime blocked their way out of the cave. Once fully formed, the trio could see jewels, gold coins and other treasures stuck deep in the black slime’s translucent body. Before the trio could consider the riches they may obtain, they moved slightly forward and engaged in a battle
                        
            BATTLE ENGAGE!\s
                        
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
            switch (option) {
                case 1 -> menuEnterChooseAttack();
                case 2 -> menuEnterChooseRun();
                case 3 -> menuEnterChooseAssist();
                case 4 -> menuEnterDisplayStats();
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

    private static void menuEnterDisplayStats()
    {
        boolean success = false;
        while (!success) {
            System.out.println("Which member would you like me to display stats for?");
            String member = scanner.nextLine();
            System.out.println(Data.displayStat(member));
            System.out.println("Would you like me to display stats for another member? (1- Yes, 2-No)");
            int answer = scanner.nextInt();
            if (answer == 2)
            {
                success = true;
            }
        }
        }
            }


    private static void menuEnterChooseAssist() {
        boolean success = false;
        while (!success) {
            System.out.println("Enter the member to assist:");
            String member = scanner.nextLine();
            success = Data.storeAssist(member);
        }
    }

    private static void menuEnterChooseRun() {
        System.out.println("Enter the member to run:");
        String member = scanner.nextLine();
        boolean runSuccess = Data.storeRun();
        System.out.printf("Run success: %b%n", runSuccess);
    }

    private static void menuEnterChooseAttack() {
        boolean success = false;
        while (!success) {
            System.out.println("Enter the member and attack type:");
            String member = scanner.nextLine();
            String attackType = scanner.nextLine();
            success = Data.storeAttack(attackType);
        }
    }
}
    


