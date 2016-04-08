package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Change;

public interface CreationChange<T extends Entity<T>> extends Change<T> {
    EntityType<T> getEntityType();
}
