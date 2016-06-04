package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Change;

public interface CreationChange<E extends Entity<E>> extends Change<E> {
    E createEntity(Entity.Id<E> entityId);
}
