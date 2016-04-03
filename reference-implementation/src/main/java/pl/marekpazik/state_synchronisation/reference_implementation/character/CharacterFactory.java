package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.Version;
import pl.marekpazik.state_synchronisation.entity.CreationChange;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityFactory;
import pl.marekpazik.state_synchronisation.reference_implementation.id.LongIdGenerator;

public class CharacterFactory implements EntityFactory<Character> {
    private final LongIdGenerator longIdGenerator;

    public CharacterFactory(LongIdGenerator longIdGenerator) {
        this.longIdGenerator = longIdGenerator;
    }

    @Override
    public Character createEntity(CreationChange<Character> creationChange) {
        assert creationChange instanceof CharacterCreated;
        CharacterCreated characterCreated = (CharacterCreated) creationChange;

        Entity.Id<Character> id = longIdGenerator.<Character>generateId();
        Character.CharacterProperties properties = new Character.CharacterProperties(characterCreated.name, characterCreated.type);
        Character.CharacterState state = new Character.CharacterState(characterCreated.position);
        return new Character(id, Version.first(), properties, state);
    }
}
