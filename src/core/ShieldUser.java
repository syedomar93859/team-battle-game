package core;

import core.Character;
import core.CharacterType;

class ShieldUser extends Character {

    public ShieldUser(String name, int hp, int atk, int def) {

        super(name, hp, atk, def, CharacterType.SHIELDUSER);

    }
}
