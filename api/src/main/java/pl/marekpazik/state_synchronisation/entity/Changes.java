package pl.marekpazik.state_synchronisation.entity;


import pl.marekpazik.state_synchronisation.Change;

import java.util.List;
import java.util.Objects;

/**
 * Entity changes since it creation. It guarantees that the first change is a {@link CreationChange}.
 */
public final class Changes<T extends Entity<T>> {
    private final List<Change<T>> changes;

    public Changes(List<Change<T>> changes) {
        assert changes.size() > 0;
        assert changes.get(0) instanceof CreationChange;
        this.changes = changes;
    }

    public CreationChange<T> getCreationChange() {
        return (CreationChange<T>) changes.get(0);
    }

    public List<Change<T>> getChanges() {
        return changes.subList(1, changes.size());
    }

    public List<Change<T>> getAsList() {
        return changes;
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
