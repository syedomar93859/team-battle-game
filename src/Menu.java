import java.util.Scanner;
import java.util.ArrayList;
public class Menu {
    public static final Scanner scanner = new Scanner(System.in);

    public static final ArrayList<String> options = new ArrayList<>();

    static
    {
        options.add("Exit");
        options.add("Choose Attack");
        options.add("Choose Run");
        options.add("Choose Assist");
    }
    //The method below is the intro message that shows up above the menu.
    private static String optMessage = """
            Store and access details of the options and actions of the members in the party and also details about foe.
            \tMenu Options
            """;
    static{
            StringBuilder sb = new StringBuilder();
            sb.append(optMessage);
            for (int i = 0; i < options.size(); i++) {
                sb.append(String.format("\t%d. %s\n", i, options.get(i)));
            }
            optMessage = sb.toString();
    }

    public static void menuLoop()
    {
        System.out.println(optMessage);
        String choice = scanner.nextLine();
        int option = Integer.parseInt(choice);
        while (option !=0)
        {
            if (option > 0 && option < options.size())
            {
                System.out.printf("Selected option %d, %s%n", option, options.get(option));
                System.out.println("Press any Enter key to continue");
                scanner.nextLine();
            }
            switch (option)
            {
                case 1 -> menuEnterChooseAttack();
                case 2 -> menuEnterChooseRun();
                case 3 -> menuEnterChooseAssist();
                default -> System.out.printf("Option %d not recognizable%n", option);
            }
            System.out.println("Press any Enter key to see menu again");
            scanner.nextLine();
            System.out.println(optMessage);
            choice = scanner.nextLine();
            option = Integer.parseInt(choice);
        }
        System.out.printf("Thank you for playing!%nBye!%n");
    }

    private static void menuEnterChooseAssist() {
    }

    private static void menuEnterChooseRun() {
    }

    private static void menuEnterChooseAttack() {
    }
}


