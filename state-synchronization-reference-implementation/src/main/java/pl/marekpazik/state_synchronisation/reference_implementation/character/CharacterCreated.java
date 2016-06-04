package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.common.Id;
import pl.marekpazik.state_synchronisation.entity.CreationChange;
import pl.marekpazik.state_synchronisation.reference_implementation.Position;
import pl.marekpazik.state_synchronisation.reference_implementation.character.GameCharacter.Properties;
import pl.marekpazik.state_synchronisation.reference_implementation.character.GameCharacter.State;

public class CharacterCreated implements CreationChange<GameCharacter> {
    public final String name;
    public final GameCharacter.GameCharacterType type;
    public final Position position;

    public CharacterCreated(String name, GameCharacter.GameCharacterType type, Position position) {
        this.name = name;
        this.type = type;
        this.position = position;
    }

    @Override
    public GameCharacter createEntity(Id<GameCharacter> entityId) {
        return new GameCharacter(entityId, new Properties(name, type), new State(position));
    }
}
