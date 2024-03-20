package core;

import core.*;
import core.Character;

import java.io.File;
import java.util.*;

public class Menu {
    public static final Scanner scanner;
    public static final ArrayList<String> options;

    static {
        scanner = new Scanner(System.in);
        options = new ArrayList();
        options.add("Exit");
        options.add("Create Team");
        options.add("Create Character");
        options.add("Update atk for character");
        options.add("Update def for character");
        options.add("Update hp for character");
        options.add("Update class for character");
        options.add("About Members");
        options.add("Determine boss's atk based on number of characters in a team");
        options.add("Ask for the top 3 members based on atk from different classes");
        options.add("Recommend a lineup of 4 based on hp and def");
        options.add("Determine damage value");
        options.add("Save data to file");
        options.add("Load data from file");
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

        List<Character> characterList = new ArrayList<>();
        Map<String, List<Character>> teams = new HashMap<>();
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
                    if (characterList.isEmpty()) {
                        System.out.println("No characters available. Please create a character first.");
                    } else {
                        System.out.println("Enter the team's name:");
                        String teamName = scanner.nextLine();
                        List<Character> team = new ArrayList<>();
                        String addMore;
                        do {
                            System.out.println("Enter the name of the character you want to add to the team:");
                            String characterName = scanner.nextLine();
                            for (Character character : characterList) {
                                if (character.getName().equals(characterName)) {
                                    team.add(character);
                                    break;
                                }
                            }
                            System.out.println("If you want to add more characters press 'y', else press any key.");
                            addMore = scanner.nextLine();
                        } while (addMore.equals("y"));
                        Team newTeam = Team.createTeam(teamName, team);
                        teams.put(newTeam.getName(), newTeam.getMembers());
                    }
                    break;


                case 2:
                    System.out.println("Choose the character's type (HEALER, MARKSMAN, SWORDSMAN, SHIELDUSER):");
                    String type = scanner.nextLine();
                    System.out.println("Enter the new character's name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the character's hp:");
                    int hp = scanner.nextInt();
                    System.out.println("Enter the character's atk:");
                    int atk = scanner.nextInt();
                    System.out.println("Enter the character's def:");
                    int def = scanner.nextInt();
                    Character newCharacter;

                    switch (type) {
                        case "HEALER":
                            newCharacter = new Healer(name, hp, atk, def);
                            characterList.add(newCharacter);
                            break;
                        case "MARKSMAN":
                            newCharacter = new Marksman(name, hp, atk, def);
                            characterList.add(newCharacter);
                            break;
                        case "SWORDSMAN":
                            newCharacter = new Swordsman(name, hp, atk, def);
                            characterList.add(newCharacter);
                            break;
                        case "SHIELDUSER":
                            newCharacter = new ShieldUser(name, hp, atk, def);
                            characterList.add(newCharacter);
                            break;
                        default:
                            System.out.println("Invalid character type. Please try again.");
                            return;
                    }
                    System.out.println("core.Character " + name + " has been created.");

                    break;

                case 3:
                    System.out.println("Enter the character's name:");
                    name = scanner.nextLine();
                    System.out.println("Enter the new attack value:");
                    int newAtk = scanner.nextInt();
                    for (Character character : characterList) {
                        if (character.getName().equals(name)) {
                            character.setAtk(newAtk);
                            System.out.println("core.Character " + name + "'s attack has been updated.");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Enter the character's name:");
                    name = scanner.nextLine();
                    System.out.println("Enter the new defense value:");
                    int newDef = scanner.nextInt();
                    for (Character character : characterList) {
                        if (character.getName().equals(name)) {
                            character.setDef(newDef);
                            System.out.println("core.Character " + name + "'s defense has been updated.");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Enter the character's name:");
                    name = scanner.nextLine();
                    System.out.println("Enter the new health value:");
                    int NewHp = scanner.nextInt();
                    for (Character character : characterList) {
                        if (character.getName().equals(name)) {
                            character.setHp(NewHp);
                            System.out.println("core.Character " + name + "'s health has been updated.");
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.println("Enter the character's name:");
                    name = scanner.nextLine();
                    System.out.println("Choose the character's type (HEALER, MARKSMAN, SWORDSMAN, SHIELDUSER):");
                    String newType = scanner.nextLine();
                    for (Character character : characterList) {
                        if (character.getName().equals(name)) {
                            character.setType(CharacterType.valueOf(newType));
                            System.out.println("core.Character " + name + "'s type has been updated.");
                            break;
                        }
                    }
                    break;

                case 7:
                    System.out.println("Would you like to view members (1) or teams? (2)");
                    int t = scanner.nextInt();
                    if (t == 1) {
                        if (characterList.isEmpty()) {
                            System.out.println("No characters available. Please create a character first.");
                        } else {
                            Collections.sort(characterList);  // sort by name
                            System.out.println(characterList);
                        }
                    } else if (t == 2) {
                        if (teams.isEmpty()) {
                            System.out.println("No teams available. Please create a team first.");
                        } else {
                            System.out.print(teams);
                        }
                    } else {
                        System.out.println("Invalid entry.");
                    }
                    break;

                /*
                case 8:
                    Battlefield.CalculateBossAtk();
                    break;

                case 9:
                    Battlefield.AskTopThreeAtk();
                    break;

                case 10:
                    Battlefield.HPAndDefLineup();
                    break;

                case 11:
                    Battlefield.CalculateDamage(member);
                    break;
                 */

                case 12:
                    save(characterList, teams);
                    break;

                case 13:
                    load(characterList, teams);
                    break;

                default:
                    System.out.printf("Option %d not recognizable%n", option);
            }

            System.out.println("\nPress any Enter key to see menu again");
            scanner.nextLine();
            System.out.println(optMessage);
            choice = scanner.nextLine();
        }
    }

    private static void save(List<Character> characterList, Map<String, List<Character>> teams) {
        String filename;
        File file;
        do {
            System.out.println("Enter a filename:");
            filename = scanner.nextLine().trim();
            file = new File(filename);
        } while (file.exists() && !file.canWrite());

        boolean success = FileSaver.save(file, characterList, teams);
        if (success) {
            System.out.println("Data saved successfully to " + filename);
        } else {
            System.out.println("Failed to save data to " + filename);
        }
    }

    private static void load(List<Character> characterList, Map<String, List<Character>> teams) {
        String filename;
        File file;
        do {
            System.out.println("Enter a filename:");
            filename = scanner.nextLine().trim();
            file = new File(filename);
        } while (!file.exists() || !file.canRead());

        FileLoader.load(file, characterList, teams);
    }
}
