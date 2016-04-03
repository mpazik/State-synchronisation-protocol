package pl.marekpazik.state_synchronisation.reference_implementation;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.ChangesStore;
import pl.marekpazik.state_synchronisation.ChangesStoreTest;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.reference_implementation.character.Character;
import pl.marekpazik.state_synchronisation.reference_implementation.character.CharacterCreated;
import pl.marekpazik.state_synchronisation.reference_implementation.character.CharacterMoved;
import pl.marekpazik.state_synchronisation.reference_implementation.id.LongId;

import java.util.Random;

public class InMemoryChangesStoreTest extends ChangesStoreTest<Character> {

    @Override
    protected Entity.Id<Character> generateId() {
        return new LongId<>(new Random().nextLong());
    }

    @Override
    protected ChangesStore createSut() {
        return new InMemoryChangesStore();
    }

    @Override
    protected CharacterCreated getCreationChange() {
        return new CharacterCreated("Roman", Character.CharacterType.Player, new Position(1, 1));
    }

    @Override
    protected Change<Character> getChange() {
        return new CharacterMoved(new Position(2, 2));
    }
}