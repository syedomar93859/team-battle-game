package core;

import java.util.List;

public abstract class Character implements Comparable<Character> {

    protected String name;
    protected int hp;
    protected int atk;
    protected int def;
    protected CharacterType type;

    /**
     * Constructs a core.Character object with the specified attributes.
     *
     * @param name name
     * @param hp   health
     * @param atk  attack
     * @param def  defense
     * @param type class
     */
    public Character(String name, int hp, int atk, int def, CharacterType type) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public CharacterType getType() {
        return type;
    }

    public void setHp(int newHp) {
        this.hp = newHp;
    }

    public void setAtk(int newAtk) {
        this.atk = newAtk;
    }

    public void setDef(int newDef) {
        this.def = newDef;
    }

    public void setType(CharacterType newType) {
        this.type = newType;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", HP: " + this.hp + ", ATK: " + this.atk + ", DEF: " + this.def + ", TYPE: " + this.type;
    }

    public static boolean CheckCharacter(int option, List<Character> characterList) {
        boolean exists = false;
        switch (option) {
            case 1:
                // check if there is a Healer in team
                for (Character character : characterList) {
                    if (character.getType() == CharacterType.HEALER) {
                        exists = true;
                        break;
                    }
                }
            case 2:
                // check if there is a Marksman in team
                for (Character character : characterList) {
                    if (character.getType() == CharacterType.MARKSMAN) {
                        exists = true;
                        break;
                    }
                }

            case 3:
                // check if there is a Swordsman in team
                for (Character character : characterList) {
                    if (character.getType() == CharacterType.SWORDSMAN) {
                        exists = true;
                        break;
                    }
                }

            case 4:
                // check if there is a ShieldUser in team
                for (Character character : characterList) {
                    if (character.getType() == CharacterType.SHIELDUSER) {
                        exists = true;
                        break;
                    }
                }

            default:
                System.out.println("Invalid option.");
                break;
        }
        return exists;
    }

    @Override
    public int compareTo(Character other) {
        return this.name.compareTo(other.name);  // sort by name
    }

}


