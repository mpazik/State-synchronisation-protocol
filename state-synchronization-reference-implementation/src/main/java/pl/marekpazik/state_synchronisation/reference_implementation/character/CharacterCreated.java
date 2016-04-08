package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.entity.CreationChange;
import pl.marekpazik.state_synchronisation.entity.EntityType;
import pl.marekpazik.state_synchronisation.reference_implementation.Position;

public class CharacterCreated implements CreationChange<GameCharacter> {
    public final String name;
    public final GameCharacter.CharacterType type;
    public final Position position;

    public CharacterCreated(String name, GameCharacter.CharacterType type, Position position) {
        this.name = name;
        this.type = type;
        this.position = position;
    }

    @Override
    public EntityType<GameCharacter> getEntityType() {
        return GameCharacter.entityType;
    }
}
