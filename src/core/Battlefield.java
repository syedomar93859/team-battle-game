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

    /**CalculateBossAtk calculates how much damage the boss deals based on a random integer between
     * 11 and 0.
     *
     */
    public Integer CalculateBossAtk(){
        Random rand = new Random();
        int highestDamageMultiplier = 11;
        int randomMultiplier = rand.nextInt(highestDamageMultiplier);
        return randomMultiplier * 1000;
    }

    /**AskTopThreeAtk goes through every party member to determine which are 3 highest dealing
     * damage members. It goes through an arraylist filled with all the members of party, and gets
     * each member's type and attack. The type and attack of each member are stored as pairs in the
     * partyDamage hashmap. Then all the details in partyDamage are used to fill and alter an array
     * called TopThreeMembers with the 3 members that deal the most amount of damage. Finally,
     * TopThreeMembers is used to print the 3 members who have the highest attack power.
     */
    public void AskTopThreeAtk(ArrayList partyDetails) {
        HashMap<String, Integer> partyDamage = new HashMap<String, Integer>();
        for (int memberIndex = 0; memberIndex < partyDetails.size(); memberIndex++) {
            Object member = partyDetails.get(memberIndex);
            partyDamage.put(member.getType, member.getAtk());
        }
        String[] TopThreeMembers = new String[partyDetails.size()];
        ArrayList allMembers = new ArrayList(partyDamage.keySet());
        ArrayList allMemberDamage = new ArrayList(partyDamage.values());

        for (int memberNum = 0; memberNum < allMembers.size(); memberNum++) {
            String currentMember = String.valueOf(allMembers.get(memberNum));
            int damage = (int) allMemberDamage.get(memberNum);
            String memberDetails = currentMember + ":" + damage;
            //Index 2 of TopThreeMembers needs to have the member with the highest damage
            String currentTopMemberDamage = TopThreeMembers[2];
            String[] memberTopParts = currentTopMemberDamage.split(":");

            String currentMiddleMemberDamage = TopThreeMembers[1];
            String[] memberMiddleParts = currentMiddleMemberDamage.split(":");

            String currentLowMemberDamage = TopThreeMembers[0];
            String[] memberLowParts = currentLowMemberDamage.split(":");

            if (TopThreeMembers[2] == null) {
                TopThreeMembers[2] = memberDetails;

            } else if (Integer.parseInt(memberTopParts[1]) > damage) {
                if (TopThreeMembers[1] == null) {
                    TopThreeMembers[1] = memberDetails;
                } else if (Integer.parseInt(memberMiddleParts[1]) > damage) {
                    if (TopThreeMembers[0] == null) {
                        TopThreeMembers[0] = memberDetails;
                    } else if (Integer.parseInt(memberMiddleParts[1]) < damage) {
                        TopThreeMembers[0] = memberDetails;
                    }
                } else {
                    String movedDetails = TopThreeMembers[1];
                    TopThreeMembers[0] = movedDetails;
                    TopThreeMembers[1] = memberDetails;
                }
            } else if (Integer.parseInt(memberTopParts[2]) < damage) {
                String movedHighDetails = TopThreeMembers[2];
                String movedMiddleDetails = TopThreeMembers[1];
                TopThreeMembers[0] = movedMiddleDetails;
                TopThreeMembers[1] = movedHighDetails;
                TopThreeMembers[2] = memberDetails;
            }
            String Top3Details = "The members who deal the most damage are:\n";
            for (int memberSelection = 0; memberSelection < TopThreeMembers.length; memberSelection++) {
                String[] selectedMemberDetails = TopThreeMembers[memberSelection].split(":");

                Top3Details = Top3Details + selectedMemberDetails[1] + "\n";
            }
            System.out.println(Top3Details);
        }
    }

    /**HPAndDefLineup is a method use to print out the health and defense of each member. This is done
     *using a for loop to loop through every member in partyDetails and get their type, hp and defense.
     * The line that needs to be printed for each member is appended to gridDetails. In the end,
     * gridDetails is printed.
     */
    public void HPAndDefLineup(ArrayList partyDetails) {
        StringBuilder gridDetails = new StringBuilder();
        for (int memberIndex = 0 ; memberIndex < partyDetails.size() ; memberIndex++){
            Object member = partyDetails.get(memberIndex);
            gridDetails.append(member.getType() + " currently has " + member.hp + " health points and " + member.getDef + " defense.\n");
        }System.out.println(gridDetails);
    }

    /**The CalculateDamage method calculates the damage dealt by a member, using their class and
     * sometimes a multiplier.
     */
    public int CalculateDamage(Object partyMember) {
        if (partyMember.getType() == "HEALER"){
            int finalDamage = partyMember.getAtk();
            return finalDamage;
        }else if (partyMember.getType() == "SWORDSMAN"){
            int finalDamage = partyMember.getAtk() * 1.5;
            return finalDamage;
        }else if (partyMember.getType() == "MARKSMAN"){
            int finalDamage = partyMember.getAtk() * 1.15;
            return finalDamage;
        }else if (partyMember.getType() == "SHIELDUSER"){
            int finalDamage = partyMember.getAtk();
            return finalDamage;
        }
        return 0;
    }

}
