package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.common.Id;

public interface CreationChange<E extends Entity<E>> extends Change<E> {
    E createEntity(Id<E> entityId);
}
