package pl.marekpazik.state_synchronisation.reference_implementation;

import com.google.common.collect.ImmutableList;
import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.ChangesStore;
import pl.marekpazik.state_synchronisation.entity.Changes;
import pl.marekpazik.state_synchronisation.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class InMemoryChangesStore implements ChangesStore {
    Map<Entity.Id<?>, List<Change<?>>> changes = new HashMap<>();

    @Override
    public <E extends Entity<E>> Changes<E> getAllChanges(Entity.Id<E> id) {
        //noinspection unchecked
        Stream<Change<E>> changeStream = changes.get(id).stream().map(change -> (Change<E>) change);
        return new Changes<>(ImmutableList.copyOf(changeStream.iterator()));
    }

    @Override
    public <E extends Entity<E>> void saveChange(Entity.Id<E> id, Change<E> change) {
        if (changes.containsKey(id)) {
            changes.get(id).add(change);
        } else {
            List<Change<?>> entityChanges = new ArrayList<>();
            entityChanges.add(change);
            changes.put(id, entityChanges);
        }
    }
}
