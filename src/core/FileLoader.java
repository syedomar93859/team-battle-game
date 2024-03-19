package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static core.CharacterType.*;

public class FileLoader {
    public static void load(File file, List<Character> characterList, Map<String, List<Character>> teams) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("Characters")) {
                    loadCharacters(br, characterList);
                } else if (line.equals("Teams")) {
                    loadTeams(br, teams, characterList);
                }
            }
            System.out.println("Data loaded successfully from " + file.getName());
        } catch (IOException e) {
            System.out.println("An error occurred while loading data from file: " + e.getMessage());
        }
    }

    private static void loadCharacters(BufferedReader br, List<Character> characterList) throws IOException {
        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            String[] parts = line.split(",");
            String name = parts[0];
            int hp = Integer.parseInt(parts[1]);
            int atk = Integer.parseInt(parts[2]);
            int def = Integer.parseInt(parts[3]);
            CharacterType type = CharacterType.valueOf(parts[4]);
            Character character = createCharacter(name, hp, atk, def, type);
            characterList.add(character);
        }
    }

    private static void loadTeams(BufferedReader br, Map<String, List<Character>> teams, List<Character> characterList) throws IOException {
        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            String[] parts = line.split(",");
            String teamName = parts[0];
            String[] memberNames = parts[1].split(";");
            List<Character> teamMembers = new ArrayList<>();
            for (String memberName : memberNames) {
                for (Character character : characterList) {
                    if (character.getName().equals(memberName)) {
                        teamMembers.add(character);
                        break;
                    }
                }
            }
            teams.put(teamName, teamMembers);
        }
    }

    private static Character createCharacter(String name, int hp, int atk, int def, CharacterType type) {
        switch (type) {
            case HEALER:
                return new Healer(name, hp, atk, def);
            case MARKSMAN:
                return new Marksman(name, hp, atk, def);
            case SWORDSMAN:
                return new Swordsman(name, hp, atk, def);
            case SHIELDUSER:
                return new ShieldUser(name, hp, atk, def);
            default:
                throw new IllegalArgumentException("Invalid character type: " + type);
        }
    }
}