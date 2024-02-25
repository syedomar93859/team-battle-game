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
    HashMap<String, Integer> startingHealth = new Hashmap<String, Integer>();
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

