package pl.marekpazik.state_synchronisation;

import pl.marekpazik.state_synchronisation.entity.Changes;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.Entity.Id;

public interface ChangesStore {

    <E extends Entity<E>> Changes<E> getAllChanges(Id<E> id);

    /**
     * All changes have to be saved to this store.
     */
    <E extends Entity<E>> void saveChange(Id<E> id, Change<E> change);
}
