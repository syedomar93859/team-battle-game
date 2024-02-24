/** Arfa Raja T09
 *  Nethanya Dhaiphule T12
 *  Syed Omar T12
 *  Feb 28, 2024
 */

import java.util.ArrayList;

public class Data {

    /**
     * Used to store the member which will be assisted
     */
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

    /**
     * Used to store the attack types
     */
    private static final ArrayList<Object[]> attacks = new ArrayList<>();

    /**
     * Used to check if the attack has been stored
     *
     * @param attackType the attack that will be selected
     * @return true if attack is stored successfully and false if not
     */
    public static boolean storeTypeOfAttack(String attackType) {
        Object[] attack = new Object[2];
        attack[0] = attackType;
        attack[1] = false;
        attacks.add(attack);
        System.out.println("Stored attack type!");
        return true;
    }
}
