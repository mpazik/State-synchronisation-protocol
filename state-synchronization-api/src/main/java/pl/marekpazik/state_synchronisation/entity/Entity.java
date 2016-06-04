package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Version;

public interface Entity<T extends Entity<T>> {

    Id<T> getId();

    /**
     * @return and immutable state of the entity
     */
    State<T> getState();

    /**
     * @return the version of the entity sate.
     */
    Version getVersion();

    /**
     * @return immutable entity properties.
     */
    Properties<T> getProperties();

    interface Id<T extends Entity<T>> {
    }

    interface State<T extends Entity<T>> {
    }

    interface Properties<T extends Entity<T>> {
    }

}
