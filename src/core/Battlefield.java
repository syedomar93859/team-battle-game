package core;

import java.util.*;

public class Battlefield{
    public Battlefield(){

    }public Integer CalculateBossAtk(){
        Random rand = new Random();
        int highestDamageMultiplier = 11;
        int randomMultiplier = rand.nextInt(highestDamageMultiplier);
        return randomMultiplier * 1000;
    }public String AskTopThreeAtk(ArrayList partyDetails) {
        HashMap<String,Integer> partyDamage = new HashMap<String,Integer>();
        for (int memberIndex = 0 ; memberIndex < partyDetails.size() ; memberIndex++){
            Object member = partyDetails.get(memberIndex);
            partyDamage.put(member.type,member.getAtk());
        }
        String[] TopThreeMembers = new String[3];
        ArrayList allMembers = new ArrayList(partyDamage.keySet());
        ArrayList allMemberDamage = new ArrayList(partyDamage.values());

        for (int memberNum = 0; memberNum < allMembers.size() ; memberNum++ ){
            String currentMember = (String) allMembers.get(memberNum);
            int damage = (int) allMemberDamage.get(memberNum);
            String memberDetails = currentMember + ":" + damage;
            //Index 2 of TopThreeMembers needs to have the member with the highest damage
            String currentTopMemberDamage = TopThreeMembers[2];
            String [] memberTopParts = currentTopMemberDamage.split(":");

            String currentMiddleMemberDamage = TopThreeMembers[1];
            String [] memberMiddleParts = currentMiddleMemberDamage.split(":");

            String currentLowMemberDamage = TopThreeMembers[0];
            String [] memberLowParts = currentLowMemberDamage.split(":");

            if (TopThreeMembers[2] == null){
                TopThreeMembers[2] = memberDetails;

            }else if(Integer.parseInt(memberTopParts[1]) > damage){
                if (TopThreeMembers[1] == null){
                    TopThreeMembers[1] = memberDetails;
                }else if(Integer.parseInt(memberMiddleParts[1]) > damage){
                    if (TopThreeMembers[0] == null) {
                        TopThreeMembers[0] = memberDetails;
                    }else if(Integer.parseInt(memberMiddleParts[1]) < damage){
                        TopThreeMembers[0] = memberDetails;
                    }
                } else{
                    String movedDetails = TopThreeMembers[1];
                    TopThreeMembers[0] = movedDetails;
                    TopThreeMembers[1] = memberDetails;
                }
            }else if (Integer.parseInt(memberTopParts[2]) < damage) {
                String movedHighDetails = TopThreeMembers[2];
                String movedMiddleDetails = TopThreeMembers[1];
                TopThreeMembers[0] = movedMiddleDetails;
                TopThreeMembers[1] = movedHighDetails;
                TopThreeMembers[2] = memberDetails;
            }
            String Top3Details = "The members who deal the most damage are:\n";
            for (int memberSelection = 0; memberSelection < TopThreeMembers.length ; memberSelection++ ){
                String[] selectedMemberDetails = TopThreeMembers[memberSelection].split(":");

                Top3Details = Top3Details + selectedMemberDetails[1] + "\n";
            }
            System.out.println(Top3Details);
        }

    }public void HPAndDefLineup() {

    }

    public void CalculateDamage(partyMember) {}

}


