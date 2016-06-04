package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.common.Id;

/**
 * Store that returns entity with the latest state for the given {@link Id}
 * All changes have to be saved to this store.
 */
public interface EntityStore {

    /**
     * Store assumes that for each id object there is corresponding entity.
     * @throws RuntimeException if there is no entity for the given id.
     */
    <E extends Entity<E>> E getEntity(Id<E> id);

    <E extends Entity<E>> void saveChange(Id<E> id, Change<E> change);
}
