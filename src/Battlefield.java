import java.util.*;
/**CPSC 233 Lecture 2
 * Tutorial 12
 * This file is used with other files for many things. It is used for creating a galacticmap, counting fighters, counting fighters that have interacted with explorers.
 * @author Syed Omar,
 */

public class Battlefield{
    public Battlefield(){

    }public Integer CalculateBossAtk(){
        Random rand = new Random();
        int highestDamageMultiplier = 11;
        int randomMultiplier = rand.nextInt(highestDamageMultiplier);
        return randomMultiplier * 1000;
    }public void AskTopThreeAtk(ArrayList partyDetails) {
        HashMap<String, Integer> partyDamage = new HashMap<String, Integer>();
        for (int memberIndex = 0; memberIndex < partyDetails.size(); memberIndex++) {
            Object member = partyDetails.get(memberIndex);
            partyDamage.put(member.type, member.getAtk());
        }
        String[] TopThreeMembers = new String[3];
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

    }public void HPAndDefLineup(ArrayList partyDetails) {
        StringBuilder gridDetails = new StringBuilder();
        for (int memberIndex = 0 ; memberIndex < partyDetails.size() ; memberIndex++){
            Object member = partyDetails.get(memberIndex);
            gridDetails.append(member.type + " currently has " + member.hp + " health points and " + member.getDef + " defense.\n");
        }System.out.println(gridDetails);
    }

    public int CalculateDamage(Object partyMember) {
        if (partyMember.type == "HEALER"){
            int finalDamage = partyMember.getAtk();
            return finalDamage;
        }else if (partyMember.type == "SWORDSMAN"){
            int finalDamage = partyMember.getAtk() * 1.5;
            return finalDamage;
        }else if (partyMember.type == "MARKSMAN"){
            int finalDamage = partyMember.getAtk() * 1.15;
            return finalDamage;
        }else if (partyMember.type == "SHIELDUSER"){
            int finalDamage = partyMember.getAtk();
            return finalDamage;
        }
        return 0;
    }

}
