package pl.marekpazik.state_synchronisation.component.store;

import pl.marekpazik.state_synchronisation.ChangesStore;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityStore;
import pl.marekpazik.state_synchronisation.entity.EntityStoreTest;
import pl.marekpazik.state_synchronisation.reference_implementation.InMemoryChangesStore;
import pl.marekpazik.state_synchronisation.reference_implementation.Position;
import pl.marekpazik.state_synchronisation.reference_implementation.character.Character;
import pl.marekpazik.state_synchronisation.reference_implementation.character.CharacterCreated;
import pl.marekpazik.state_synchronisation.reference_implementation.character.CharacterFactory;
import pl.marekpazik.state_synchronisation.reference_implementation.id.LongIdGenerator;

public class BuildingFromScratchEntityStoreTest extends EntityStoreTest<Character> {
    private final ChangesStore changesStore = new InMemoryChangesStore();
    private final LongIdGenerator longIdGenerator = new LongIdGenerator();
    private final EntityFactoryRegistry entityFactoryRegistry = EntityFactoryRegistry.builder()
            .addEntityFactory(Character.entityType, new CharacterFactory(longIdGenerator))
            .build();

    @Override
    protected EntityStore createSut() {
        return new BuildingFromScratchEntityStore(entityFactoryRegistry, changesStore);
    }

    @Override
    protected Entity.Id<Character> generateId()
    {
        return longIdGenerator.generateId();
    }

    @Override
    protected CharacterCreated getCreationChange() {
        return new CharacterCreated("Roman", Character.CharacterType.Player, new Position(1, 1));
    }

}