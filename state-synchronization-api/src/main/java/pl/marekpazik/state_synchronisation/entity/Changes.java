package pl.marekpazik.state_synchronisation.entity;


import com.google.common.collect.ImmutableList;
import pl.marekpazik.state_synchronisation.Change;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Entity changes since it creation. It guarantees that the first change is a {@link CreationChange}.
 */
public final class Changes<T extends Entity<T>> {
    private final CreationChange<T> creationChange;
    private final List<UpdateChange<T>> changes;

    public Changes(List<Change<T>> changes) {
        assert changes.size() > 0;
        assert changes.get(0) instanceof CreationChange;
        creationChange = (CreationChange<T>) changes.get(0);
        this.changes = changes.stream().skip(1).map(change -> (UpdateChange<T>) change).collect(Collectors.toList());
    }

    public CreationChange<T> getCreationChange() {
        return creationChange;
    }

    public List<UpdateChange<T>> getUpdateChanges() {
        return changes;
    }

    public List<Change<T>> getAsList() {
        return ImmutableList.<Change<T>>builder().add(creationChange).addAll(changes).build();
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
