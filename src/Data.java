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

    public static String displayStat(String member)
    {
        // method to get member stat and return it
    }
}
