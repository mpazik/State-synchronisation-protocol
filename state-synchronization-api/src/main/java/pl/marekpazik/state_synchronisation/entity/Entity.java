package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Version;
import pl.marekpazik.state_synchronisation.common.Id;

public interface Entity<E extends Entity<E>> {

    Id<E> getId();

    /**
     * @return and immutable state of the entity
     */
    EntityState<E> getState();

    /**
     * @return immutable entity properties.
     */
    EntityProperties<E> getProperties();

    /**
     * @return the version of the entity sate.
     */
    Version getVersion();

}
