/** Arfa Raja T09
 *  Nethanya Dhaiphule T12
 *  Syed Omar T12
 *  Feb 28, 2024
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**SlimeBoss
 10000 health level
 takes turn after all members have had a turn

 Special Attack (SLIME CANON)
 deals damage to all of the members (AOE) , takes two turn~ First round announcement~ Second round damage
 800 dmg

 net — 02/22/2024 3:09 PM
 Regular Attack
 SlimeTackle
 target one member
 take one turn
 do good amount of damage to one player
 500 dmg

 Defense Action
 Reflect Attack
 Only use 2 times during battle
 half of the damage player does will be given back to the player
 Effects player for two rounds
 The player must attack the opponent for two consecutive rounds

 arfa — 02/22/2024 3:18 PM
 potion user - 2000 hp
 reg attack - punch. 100 dmg.
 poison (3 times max per battle) - poison status effect lasts for 3 turns to foe. foe takes 150 dmg after foe's turn.
 glass shards (once per 7 turns. once max per battle) - when foe attacks potion user, foe takes 150 dmg
 run
 assist - raise health by 750 hp for all party members

 sword user - 2500 hp
 reg attack - slash, 200 dmg
 wide slash (once per 3 turns) - 150dmg to each foe
 lucky stab (once per 5 turns) - 250 dmg with a 50% chance to double and do 500 dmg
 run
 assist - raise atk for one party member by 150% for 3 turns.

 shield user - 5000 hp
 reg attack - shield bash. 100 dmg
 protect (once per 3 turns) - takes 50% of dmg inflicted to one team member
 party grace (once per 7 turns) - protects all party members
 run
 assist - raise health by 1500 hp for one party member
 */
public class Data {
    public static HashMap<String,Integer> beginningHealth(){
        HashMap<String, Integer> startingHealth = new HashMap<String, Integer>();
        startingHealth.put("Potioneer", 2000);
        startingHealth.put("Swordsman", 2500);
        startingHealth.put("Shield User", 5000);
        startingHealth.put("Slime Boss", 10000);
        return startingHealth;
    }

    /**
     * Used to calculate the damage of a single affect attack
     *
     * @param member the member that will be taking action
     * @param action the action the member will take
     * @return the int total affect of the action
     */
    public static int singleAffect(String member, int action) {
        int damage = 0;
        // Determine how much a singular member is healed or singular foe is damaged
        if (member.equals("Potioneer")) {
            if (action == 1) { // Regular attack - punch
                damage = -100; // Damage is represented as negative
            } else if (action == 2) { // Poison
                damage = -150;
            } else if (action == 3) { // Glass shards
                damage = -150;
            }
        } else if (member.equals("Swordsman")) {
            if (action == 1) { // Regular attack - slash
                damage = -200;
            } else if (action == 2) { // Lucky stab
                double chance = Math.random(); // 50% chance to deal double damage
                if (chance < 0.5) {
                    damage = -500;
                } else {
                    damage = -250;
                }
            }
        } else if (member.equals("Shield User")) {
            if (action == 1) { // Regular attack - shield bash
                damage = -100;
            }
        }
        return damage;
    }

    /**
     * Used to calculate the damage of an AoE attack
     *
     * @param member the member that will be taking action
     * @param action the action the member will take
     * @return the int total affect of the action
     */
    public static int areaAffect(String member, int action) {
        int change = 0;
        if (member.equals("Swordsman")) {
            if (action == 2) { // Wide slash
                change = -150; 
            }
        } else if (member.equals("Shield User")) {
            if (action == 2) { // Protect
                change = 0; // No change in health
            } else if (action == 3) { // Party grace
                change = 0;
            }
        }
        return change;
    }

    public static int attackDetails(String member, int action) {
        int affect = 0;
        boolean isAoE = false;
        if (isAoE) {
            affect = areaAffect(member, action);
        } else {
            affect = singleAffect(member, action);
        }
        return affect;
    }
    public static boolean assistDetermining(String member) {
        boolean assistSuccess = false;
        // Determine the success rate for the member's assist action
        return assistSuccess;
    }

    public static int actionCheck(String member,int action, int attackAction, String affectedMember) {
        //attackDetails is a method that I have not created yet that will calculate the whatever the attack is of the member
        //assistDetermining is a method that determines if an assist is successful as they have a chance to fail
        //a is a method that
        if (member == "Potioneer") {
            //I don't think there should be an if statement checking to see if the option chosen was Exit, as Menu.java
            //alone can deal with it
            if (action == 2) {
                int damage = Data.attackDetails(String member, int attackPotioneerAction);
                return damage;
            }
            //I also think Menu.java can deal with Run.
            else if (action == 4) {
                boolean assistSuccess = Data.assistDetermining(String member);
                if (assistSuccess == true) {
                    return -1;//You should probably come up with something more complicated than -1. Since all the calculating needs to happen in Data.java, there
                    //could be another method that calulates  the improved health of all the members.
                } else if (assistSuccess == false) {
                    return -2;
                }
                //I was thinking that Menu.java can use the returned negative number to determine is the assist worked or not.
            }
        } else if (member == "Swordsman") {
            if (action == 2) {
                int damage = Data.attackDetails(String member, int attackSwordsmanAction);
                return damage;
            } else if (action == 4) {
                boolean assistSuccess = Data.assistDetermining(String member);
                if (assistSuccess == true) {
                    return -1;// I think Menu.java should take this -1 and let a loop go on for 3 rounds which would call a different method separate from actionCheck
                    //in each round to calculate the damage dealt by new attacks.
                } else if (assistSuccess == false) {
                    return -2;
                }
            }
        } else if (member == "Shield User") {
            if (action == 2) {
                int damage = Data.attackDetails(String member, int attackShieldUserAction);
                return damage;
            } else if (action == 4) {
                boolean assistSuccess = Data.assistDetermining(String member);
                if (assistSuccess == true) {
                    int memberImprovedHealth = Data.assistNewHealth(affectedMember);
                    //memberImprovedHealth should instead store the improved health of all party members which is not possible with the current actionCheck as it can only return
                    //int and not hashmaps which would be more suitable.
                    return memberImprovedHealth;
                } else if (assistSuccess == false) {
                    return -2;
                }
            }
        }
    }
}

public static HashMap<String,Integer> newFoeHealth(){
    HashMap<String, Integer> newFoeHealth = new HashMap<String, Integer>();

    return startingHealth;

    /**
     * Used to store the member which will be assisted
     */
    public static boolean exitGame(){
        return false;
    }
    public static boolean storeAttack(String member) {
        return false;
    }
    public static boolean storeRun(){
        return false;}


    private static final ArrayList<Object[]> members = new ArrayList<>();

    /**
     * Used to check if the member has been stored
     *
     * @param member the member that will be assisted
     * @return true if member is stored successfully and false if not
     */
    public static boolean storeAssist (String member){
        Object[] id = new Object[2];
        id[0] = member;
        id[1] = false;
        members.add(id);
        System.out.println("Stored member to assist!");
        return true;
    }
    public static int calculatingEntityHealth(){

    }
    public static int displayEntityHealth(){
        for(int entityIndex = 0; entityIndex < entities.length; entityIndex++){
            if (entityIndex == 0){
                potioneerHealth =
            }
        }
        return 4;
    }
}

