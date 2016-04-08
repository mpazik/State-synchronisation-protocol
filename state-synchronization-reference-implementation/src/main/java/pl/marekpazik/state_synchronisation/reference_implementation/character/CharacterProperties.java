package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.entity.Entity;

public final class CharacterProperties implements Entity.Properties<GameCharacter> {
    public final String name;
    public final GameCharacter.CharacterType characterType;

    public CharacterProperties(String name, GameCharacter.CharacterType characterType) {
        this.name = name;
        this.characterType = characterType;
    }
}
