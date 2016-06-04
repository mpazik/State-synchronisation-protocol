package pl.marekpazik.state_synchronisation.reference_implementation;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.ChangesStore;
import pl.marekpazik.state_synchronisation.ChangesStoreTest;
import pl.marekpazik.state_synchronisation.common.Id;
import pl.marekpazik.state_synchronisation.reference_implementation.character.CharacterCreated;
import pl.marekpazik.state_synchronisation.reference_implementation.character.CharacterMoved;
import pl.marekpazik.state_synchronisation.reference_implementation.character.GameCharacter;
import pl.marekpazik.state_synchronisation.reference_implementation.id.LongId;

import java.util.Random;

public class InMemoryChangesStoreTest extends ChangesStoreTest<GameCharacter> {

    @Override
    protected Id<GameCharacter> generateId() {
        return new LongId<>(new Random().nextLong());
    }

    @Override
    protected ChangesStore createSut() {
        return new InMemoryChangesStore();
    }

    @Override
    protected CharacterCreated getCreationChange() {
        return new CharacterCreated("Roman", GameCharacter.GameCharacterType.Player, new Position(1, 1));
    }

    @Override
    protected Change<GameCharacter> getChange() {
        return new CharacterMoved(new Position(2, 2));
    }
}