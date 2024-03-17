public abstract class Character
{
    private String name;
    private int atk;
    private int hp;
    private int def;
    private CharacterType type;

    public Character(String name, int hp, int atk, int def, CharacterType characterType)
    {
            this.name = name;
            this.atk = atk;
            this.hp = hp;
            this.def = def;
            this.type = characterType;
    }

    protected int setAtk()
    {
        return atk;
    }

    protected void setHp()
    {

    }

    protected void setDef()
    {

    }

    protected int getAtk()
    {
        return atk;
    }

    protected int getHp()
    {
        return hp;
    }

    protected int getDef()
    {
        return def;
    }




}


