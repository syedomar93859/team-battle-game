import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @org.junit.jupiter.api.Test
    void singleAffect() {
        //This test makes sure the damage value calculated in the singleAffect method is calculated properly.
        int expectedDamage = -200;
        int actualDamage = Data.singleAffect("Swordsman", 1);
        assertTrue(expectedDamage == actualDamage);
    }

    @org.junit.jupiter.api.Test
    void areaAffect() {
        //This test checks to see if the damage value calculated in areaAffect is correct.
        int expectedChange = 0;
        int actualChange = Data.areaAffect("Shield User", 2);
        assertTrue(expectedChange == actualChange);
    }

    @org.junit.jupiter.api.Test
    void assistNewHealth() {
        //This method calculates the increased health of a party member by taking into account their current health and the party member trying to heal them.
        //This test makes sure the increased health is properly calculated.
        int expectedImprovedHealth = 3500;
        int actualImprovedHealth = Data.assistNewHealth("Shield User", "Potioneer");
        assertTrue(expectedImprovedHealth == actualImprovedHealth);
    }

    @org.junit.jupiter.api.Test
    void assistNewAttack() {
        //Similar to assistNewHealth, but instead this method calculates the increased attack. This test makes sure that the increased
        //attack is correct.
        int expectedImprovedAttack = 150;
        int actualImprovedAttack = Data.assistNewAttack("Swordsman", "Shield User");
        assertTrue(expectedImprovedAttack == actualImprovedAttack);
    }

    @org.junit.jupiter.api.Test
    void AboutMembers() {
        //This method takes a party member and returns all their details in a readable format. This test makes sure what is returned
        //are readable details of the party member.
        String expectedMemberInfo =
                "Sword user: 2500 hp\n" +
                        "Attack - 200 dmg\n" +
                        "Skill - Lucky Stab: 250 dmg with 50% chance to deal double\n" +
                        "Burst - Desperate Slash: Damage equal to 160000 divided by health\n" +
                        "Assist:  Raise atk by 150\n";
        String actualMemberInfo = Data.AboutMembers(2);
        assertTrue(expectedMemberInfo.equals(actualMemberInfo));
    }

    @org.junit.jupiter.api.Test
    void displayStat() {
        //This test checks to see if the health and name of the party member is properly displayed.
        String expectedDisplay = "Stats for Potioneer:\nHealth: 2000\n";
        String actualDisplay = Data.displayStat("Potioneer");
        assertTrue(expectedDisplay.equals(actualDisplay));
    }
}