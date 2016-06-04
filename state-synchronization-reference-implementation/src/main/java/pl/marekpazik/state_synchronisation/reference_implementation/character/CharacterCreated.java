package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.entity.CreationChange;
import pl.marekpazik.state_synchronisation.entity.Entity;
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
    public GameCharacter createEntity(Entity.Id<GameCharacter> entityId) {
        return new GameCharacter(entityId, new CharacterProperties(name, type), new CharacterState(position));
    }
}
