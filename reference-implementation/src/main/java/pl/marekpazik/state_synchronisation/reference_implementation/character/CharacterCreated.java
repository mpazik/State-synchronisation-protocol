package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.entity.CreationChange;
import pl.marekpazik.state_synchronisation.entity.EntityType;
import pl.marekpazik.state_synchronisation.reference_implementation.Position;

public class CharacterCreated implements CreationChange<Character> {
    public final String name;
    public final Character.CharacterType type;
    public final Position position;

    public CharacterCreated(String name, Character.CharacterType type, Position position) {
        this.name = name;
        this.type = type;
        this.position = position;
    }

    @Override
    public EntityType<Character> getEntityType() {
        return Character.entityType;
    }
}
