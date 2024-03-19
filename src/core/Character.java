package core;

public abstract class Character {

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
}


