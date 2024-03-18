import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Character> members;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(Character character) {
        this.members.add(character);
    }

    public String getName() {
        return this.name;
    }

    public List<Character> getMembers() {
        return this.members;
    }

    public static Team createTeam(String teamName, List<Character> teamMembers) {
        Team newTeam = new Team(teamName);
        for (Character member : teamMembers) {
            newTeam.addMember(member);
        }
        System.out.println("Team " + teamName + " has been created.");
        return newTeam;
    }
}
