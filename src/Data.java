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

    /**
     * Used to determine if the action is an AoE or single attack
     *
     * @param member the member that will be taking action
     * @param action the action the member will take
     * @return the int total affect of the action
     */
    public static int attackDetails(String member, int action) {
        int affect = 0;
        boolean isAoE = (member.equals("Swordsman") && action == 2) ||
                (member.equals("Shield User") && (action == 2 || action == 3));
        if (isAoE) {
            affect = areaAffect(member, action);
        } else {
            affect = singleAffect(member, action);
        }
        return affect;
    }

    /**
     * Used to determine the improved health
     *
     * @param member the member that will be taking action
     * @return the int total affect of the action
     */
    public static int assistNewHealth(String member) {
        int improvedHealth = 0;
        if (member.equals("Potioneer")) {
            improvedHealth = 750; // Potioneer raises health by 750 HP for all party members
        } else if (member.equals("Shield User")) {
            improvedHealth = 1500; // Shield User raises health by 1500 HP for one party member
        }
        return improvedHealth;
    }

    /**
     * Used to determine the improved attack
     *
     * @param member the member that will be taking action
     * @return the int total affect of the action
     */
    public static int assistNewAttack(String member) {
        int improvedAttack = 0;
        if (member.equals("Swordsman")) {
            improvedAttack = 150; // Swordsman raises attack for one party member by 150% for 3 turns
        }
        return improvedAttack;
    }

    /**
     * Used to determine the action taken
     *
     * @param member the member that will be taking action
     * @param action the action the member will take
     * @param attackAction the int total affect of the action
     * @param affectedMember the member that will be affected by an assist
     * @return the int total affect of the action
     */
    public static int actionCheck(String member, int action, int attackAction, String affectedMember) {
        if (member.equals("Potioneer")) {
            if (action == 2) {
                int damage = Data.attackDetails(member, attackAction);
                return damage;
            } else if (action == 4) {
                // You should probably come up with something more complicated than -1. Since all the calculating needs to happen in Data.java, there
                // could be another method that calulates  the improved health of all the members.
                int improvedHealth = Data.assistNewHealth(affectedMember);
                return improvedHealth;
            }
        } else if (member.equals("Swordsman")) {
            if (action == 2) {
                int damage = Data.attackDetails(member, attackAction);
                return damage;
            } else if (action == 4) {
                // I think Menu.java should take this -1 and let a loop go on for 3 rounds which would call a different method separate from actionCheck
                // in each round to calculate the damage dealt by new attacks.
                int improvedAttack = Data.assistNewAttack(affectedMember);
                return improvedAttack;
            }
        } else if (member.equals("Shield User")) {
            if (action == 2) {
                int damage = Data.attackDetails(member, attackAction);
                return damage;
            } else if (action == 4) {
                // memberImprovedHealth should instead store the improved health of all party members which is not possible with the current actionCheck as it can only return
                // int and not hashmaps which would be more suitable.
                int memberImprovedHealth = Data.assistNewHealth(affectedMember);
                return memberImprovedHealth;
            }
        }
        return 0;
    }

    /**
     * Used to determine the foes' health
     *
     * @param foe the foe that will be taking action
     * @param member the member that will be taking action
     * @param action the action the member will take
     * @return the int total affect of the action
     */
    public static HashMap<String, Integer> newFoeHealth(String foe, String member, int action) {
        HashMap<String, Integer> newFoeHealth = new HashMap<String, Integer>();

        // Get the old health of the foe
        int oldHealth = newFoeHealth.get(foe);

        // Determine if the action is an AoE or not
        boolean isAoE = (member.equals("Swordsman") && action == 2) ||
                (member.equals("Shield User") && (action == 2 || action == 3));

        // Calculate the damage based on the action
        int damage;
        if (isAoE) {
            damage = areaAffect(member, action);
        } else {
            damage = singleAffect(member, action);
        }

        // Calculate the new health based on the old health and the damage
        int newHealth = oldHealth - damage;

        // Update the health of the foe
        newFoeHealth.put(foe, newHealth);

        return newFoeHealth;
    }


    /**
     * Used to store the exit
     */
    public static boolean exitGame(){
        return false;
    }

    /**
     * Used to store the member attack
     */
    public static boolean storeAttack(String member, int action) {
        int damage = singleAffect(member, action);
        int change = areaAffect(member, action);

        // Store the damage and change values
        System.out.println("Damage: " + damage);
        System.out.println("Change: " + change);

        return false;
    }


    /**
     * Used to store the run
     *
     * @param member the member that will be taking action
     * @return the int total affect of the action
     */
    public static boolean storeRun(String member) {
        System.out.println("The character has chosen to run!");
        return true; // Return true to indicate run was successful.
    }

    /**
     * Used to check if the member has been stored
     *
     * @param member the member that will be assisted
     * @return true if member is stored successfully and false if not
     */
    private static final ArrayList<Object[]> members = new ArrayList<>();
    public static boolean storeAssist (String member){
        Object[] id = new Object[2];
        id[0] = member;
        id[1] = false;
        members.add(id);
        System.out.println("Stored member to assist!");
        return true;
    }

    public static String displayStat(String member) {

        String stats = "Stats for " + member + ":\n";

        // Add the stats for the member
        stats += "Health: " + beginningHealth().get(member) + "\n";

        // Add the improved health and attack stats
        stats += "Improved Health: " + assistNewHealth(member) + "\n";
        stats += "Improved Attack: " + assistNewAttack(member) + "\n";

        return stats;
    }public static int desperateSlash(swordsmanHealth) {
        //This method will determine the damage dealt by the desperate slash of the swordsman using his health.
        int damage = 160000 / swordsmanHealth;
        return damage;
    }public static int attackEnhancment(attackDamage){
        //This method will take the attack that needs to be enhanced and calculates damage of the enhanced attack.
        int enhancedDamage = attackDamge * 1.5;
        return enhancedDamage;
    }
}



