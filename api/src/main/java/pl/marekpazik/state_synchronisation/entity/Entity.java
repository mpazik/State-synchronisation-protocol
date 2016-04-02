package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.Version;

public interface Entity<T extends Entity<T>> {

    Id<T> getId();

    /**
     * @return and immutable state of the entity
     */
    State<T> getState();

    /**
     * Applies the change which will update the state and increase the version.
     */
    void applyChange(Change<T> change);

    /**
     * @return the version of the entity sate.
     */
    Version getVersion();

    /**
     * @return immutable entity properties.
     */
    Properties<T> getProperties();

    interface Id<T> {
    }

    interface State<T> {
    }

    interface Properties<T> {
    }

}
