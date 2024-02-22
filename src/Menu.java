import java.util.Scanner;
import java.util.ArrayList;
public class Menu {
    public static final Scanner scanner = new Scanner(System.in);

    public static final ArrayList<String> options = new ArrayList<>();
    static {
        options.add("Exit");
        //Add more menu options
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


    public static void menuLoop(){
        System.out.println(optMessage);
    }
}
//hello

