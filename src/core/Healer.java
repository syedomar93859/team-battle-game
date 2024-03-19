package core;

import core.Character;
import core.CharacterType;

class Healer extends Character {

    public Healer(String name, int hp, int atk, int def) {

        super(name, hp, atk, def, CharacterType.HEALER);

    }
}
