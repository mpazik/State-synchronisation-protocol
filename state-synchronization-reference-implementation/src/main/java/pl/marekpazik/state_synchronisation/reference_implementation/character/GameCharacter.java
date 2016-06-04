package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.common.Id;
import pl.marekpazik.state_synchronisation.entity.AbstractEntity;
import pl.marekpazik.state_synchronisation.entity.EntityType;
import pl.marekpazik.state_synchronisation.reference_implementation.StringEntityType;

public final class GameCharacter extends AbstractEntity<GameCharacter, CharacterProperties, CharacterState> {

    public static EntityType<GameCharacter> entityType = new StringEntityType<>("character");

    public GameCharacter(Id<GameCharacter> id, CharacterProperties properties, CharacterState state) {
        super(id, properties, state);
    }

    public enum CharacterType {
        Player,
        Mob
    }
}
