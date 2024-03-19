package core;

import core.Character;
import core.CharacterType;

class Swordsman extends Character {

    public Swordsman(String name, int hp, int atk, int def) {

        super(name, hp, atk, def, CharacterType.SWORDSMAN);

    }
}
