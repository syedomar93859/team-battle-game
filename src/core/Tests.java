package core;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

    public class Tests {

        // Test for checking character type existence
        @Test
        public void testCheckCharacter() {
            // Given: Populate a list with different types of characters
            List<Character> characterList = new ArrayList<>();
            characterList.add(new Healer("Healer1", 100, 50, 30));
            characterList.add(new Marksman("Marksman1", 120, 60, 40));
            characterList.add(new Swordsman("Swordsman1", 150, 70, 50));
            characterList.add(new ShieldUser("ShieldUser1", 200, 80, 60));

            // When: Check if characters of each type exist
            boolean healerExists = Menu.CheckCharacter(1, characterList);
            boolean marksmanExists = Menu.CheckCharacter(2, characterList);
            boolean swordsmanExists = Menu.CheckCharacter(3, characterList);
            boolean shieldUserExists = Menu.CheckCharacter(4, characterList);

            // Then: Ensure that each type of character exists
            assertTrue(healerExists);
            assertTrue(marksmanExists);
            assertTrue(swordsmanExists);
            assertTrue(shieldUserExists);
        }

        // Test for character creation
        @Test
        public void testCharacterCreation() {
            // Given: An empty list of characters

            // When: Create a new character and add it to the list
            List<Character> characterList = new ArrayList<>();
            Character newCharacter = new Healer("NewHealer", 100, 50, 30);
            characterList.add(newCharacter);

            // Then: Ensure that the character is created correctly
            assertEquals(1, characterList.size());
            assertEquals("NewHealer", characterList.get(0).getName());
            assertEquals(100, characterList.get(0).getHp());
            assertEquals(50, characterList.get(0).getAtk());
            assertEquals(30, characterList.get(0).getDef());
        }

        // Test for team creation
        @Test
        public void testTeamCreation() {
            // Given: A list with two different types of characters
            List<Character> characterList = new ArrayList<>();
            Character healer = new Healer("Healer1", 100, 50, 30);
            Character marksman = new Marksman("Marksman1", 120, 60, 40);
            characterList.add(healer);
            characterList.add(marksman);

            // When: Create a team using the characters
            String teamName = "Team1";
            List<Character> teamMembers = new ArrayList<>();
            teamMembers.add(healer);
            teamMembers.add(marksman);
            Team team = Team.createTeam(teamName, teamMembers);

            // Then: Ensure that the team is created correctly
            assertEquals(teamName, team.getName());
            assertEquals(2, team.getMembers().size());
            assertTrue(team.getMembers().contains(healer));
            assertTrue(team.getMembers().contains(marksman));
        }
    }

