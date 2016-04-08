package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.Version;
import pl.marekpazik.state_synchronisation.entity.CreationChange;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityFactory;
import pl.marekpazik.state_synchronisation.reference_implementation.id.LongIdGenerator;

public class CharacterFactory implements EntityFactory<GameCharacter> {
    private final LongIdGenerator longIdGenerator;

    public CharacterFactory(LongIdGenerator longIdGenerator) {
        this.longIdGenerator = longIdGenerator;
    }

    @Override
    public GameCharacter createEntity(CreationChange<GameCharacter> creationChange) {
        assert creationChange instanceof CharacterCreated;
        CharacterCreated characterCreated = (CharacterCreated) creationChange;

        Entity.Id<GameCharacter> id = longIdGenerator.<GameCharacter>generateId();
        CharacterProperties properties = new CharacterProperties(characterCreated.name, characterCreated.type);
        CharacterState state = new CharacterState(characterCreated.position);
        return new GameCharacter(id, Version.first(), properties, state);
    }
}
