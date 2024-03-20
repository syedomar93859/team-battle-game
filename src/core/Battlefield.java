/**
 *  Arfa Raja, Nethanya Dhaipule, Syed Omar
 *  March 20, 2024
 *  T12
 */
package core;


import java.util.*;

public class Battlefield{

    public Battlefield() {

    }

    /**
     * CalculateBossAtk calculates how much damage the boss deals based on a random integer between 11 and 0.
     *
     * @return int with boss's damage
     */
    public static Integer CalculateBossAtk(){
        Random rand = new Random();
        int highestDamageMultiplier = 11;
        int randomMultiplier = rand.nextInt(highestDamageMultiplier);
        return randomMultiplier * 1000;
    }

    /**
     * AskTopThreeAtk goes through every party member to determine which are 3 highest dealing damage members.
     *
     */
    public static void AskTopThreeAtk(ArrayList<Character> characterList) {
        HashMap<String, Integer> partyDamage = new HashMap<String, Integer>();
        // It goes through an arraylist filled with all the members of party, and gets each member's type and attack.
        for (Character member : characterList) {
            //  The type and attack of each member are stored as pairs in the partyDamage hashmap.
            partyDamage.put(member.getType().toString(), member.getAtk());
        }
        // Then all the details in partyDamage are used to fill and alter an array called TopThreeMembers
        // with the 3 members that deal the most amount of damage.
        String[] TopThreeMembers = new String[3];
        ArrayList<String> allMembers = new ArrayList<String>(partyDamage.keySet());
        ArrayList<Integer> allMemberDamage = new ArrayList<Integer>(partyDamage.values());

        for (int memberNum = 0; memberNum < allMembers.size(); memberNum++) {
            String currentMember = allMembers.get(memberNum);
            int damage = allMemberDamage.get(memberNum);
            String memberDetails = currentMember + ":" + damage;

            for (int i = 0; i < TopThreeMembers.length; i++) {
                if (TopThreeMembers[i] == null || Integer.parseInt(TopThreeMembers[i].split(":")[1]) < damage) {
                    for (int j = TopThreeMembers.length - 1; j > i; j--) {
                        TopThreeMembers[j] = TopThreeMembers[j - 1];
                    }
                    TopThreeMembers[i] = memberDetails;
                    break;
                }
            }
        }
        // Finally, TopThreeMembers is used to print the 3 members who have the highest attack power.
        String Top3Details = "The members who deal the most damage are:\n";
        for (String member : TopThreeMembers) {
            if (member != null) {
                Top3Details += member.split(":")[0] + " with damage: " + member.split(":")[1] + "\n";
            }
        }
        System.out.println(Top3Details);
    }

    /**
     * HPAndDefLineup is a method use to print out the health and defense of each member.
     */
    public static void HPAndDefLineup(ArrayList<Character> characterList) {
        StringBuilder gridDetails = new StringBuilder();
        //  This is done using a for loop to loop through every member in partyDetails and get their type, hp and defense.
        for (int memberIndex = 0 ; memberIndex < characterList.size() ; memberIndex++){
            Character member = (Character) characterList.get(memberIndex);
            // The line that needs to be printed for each member is appended to gridDetails.
            gridDetails.append(member.getType() + " currently has " + member.hp + " health points and " + member.def + " defense.\n");
        } // In the end,gridDetails is printed.
        System.out.println(gridDetails);
    }

    /**
     * The CalculateDamage method calculates the damage dealt by a member, using their class and sometimes a multiplier.
     *
     * @return int damage from member
     */
    public static int CalculateDamage(Character partyMember) {
        double finalDamage = 0;
        if (partyMember.getType() == CharacterType.HEALER){
            finalDamage = partyMember.getAtk();
        } else if (partyMember.getType() == CharacterType.SWORDSMAN){
            finalDamage = partyMember.getAtk() * 1.5;
        } else if (partyMember.getType() == CharacterType.MARKSMAN){
            finalDamage = partyMember.getAtk() * 1.15;
        } else if (partyMember.getType() == CharacterType.SHIELDUSER){
            finalDamage = partyMember.getAtk();
        }
        return (int) Math.round(finalDamage);
    }

}
