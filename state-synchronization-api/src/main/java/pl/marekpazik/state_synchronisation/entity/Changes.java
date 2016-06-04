package pl.marekpazik.state_synchronisation.entity;


import com.google.common.collect.ImmutableList;
import pl.marekpazik.state_synchronisation.Change;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Entity changes since it creation. It guarantees that the first change is a {@link CreationChange}.
 */
public final class Changes<E extends Entity<E>> {
    private final CreationChange<E> creationChange;
    private final List<UpdateChange<E>> changes;

    public Changes(List<Change<E>> changes) {
        assert changes.size() > 0;
        assert changes.get(0) instanceof CreationChange;
        creationChange = (CreationChange<E>) changes.get(0);
        this.changes = changes.stream().skip(1).map(change -> (UpdateChange<E>) change).collect(Collectors.toList());
    }

    public CreationChange<E> getCreationChange() {
        return creationChange;
    }

    public List<UpdateChange<E>> getUpdateChanges() {
        return changes;
    }

    public List<Change<E>> getAsList() {
        return ImmutableList.<Change<E>>builder().add(creationChange).addAll(changes).build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Changes<?> changes1 = (Changes<?>) o;
        return Objects.equals(changes, changes1.changes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(changes);
    }

    @Override
    public String toString() {
        return "Changes{" +
                "changes=" + changes +
                '}';
    }
}
