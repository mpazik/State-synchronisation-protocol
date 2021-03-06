package pl.marekpazik.state_synchronisation.component.store;

import pl.marekpazik.state_synchronisation.ChangesStore;
import pl.marekpazik.state_synchronisation.common.Id;
import pl.marekpazik.state_synchronisation.entity.EntityStore;
import pl.marekpazik.state_synchronisation.entity.EntityStoreTest;
import pl.marekpazik.state_synchronisation.reference_implementation.InMemoryChangesStore;
import pl.marekpazik.state_synchronisation.reference_implementation.Position;
import pl.marekpazik.state_synchronisation.reference_implementation.character.CharacterCreated;
import pl.marekpazik.state_synchronisation.reference_implementation.character.GameCharacter;
import pl.marekpazik.state_synchronisation.reference_implementation.id.LongIdGenerator;

public class BuildingFromScratchEntityStoreTest extends EntityStoreTest<GameCharacter> {
    private final ChangesStore changesStore = new InMemoryChangesStore();
    private final LongIdGenerator longIdGenerator = new LongIdGenerator();

    @Override
    protected EntityStore createSut() {
        return new BuildingFromChangesEntityStore(changesStore);
    }

    @Override
    protected Id<GameCharacter> generateId()
    {
        return longIdGenerator.generateId();
    }

    @Override
    protected CharacterCreated getCreationChange() {
        return new CharacterCreated("Roman", GameCharacter.GameCharacterType.Player, new Position(1, 1));
    }

}