package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Version;
import pl.marekpazik.state_synchronisation.common.Id;

public interface Entity<E extends Entity<E>> {

    Id<E> getId();

    /**
     * @return and immutable state of the entity
     */
    State<E> getState();

    /**
     * @return the version of the entity sate.
     */
    Version getVersion();

    /**
     * @return immutable entity properties.
     */
    Properties<E> getProperties();

    interface State<E extends Entity<E>> {
    }

    interface Properties<E extends Entity<E>> {
    }

}
