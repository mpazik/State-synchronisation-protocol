package pl.marekpazik.state_synchronisation;

import pl.marekpazik.state_synchronisation.entity.Changes;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.Entity.Id;

public interface ChangesStore {

    <T extends Entity<T>> Changes<T> getAllChanges(Id<T> id);

    /**
     * All changes have to be saved to this store.
     */
    <T extends Entity<T>> void saveChange(Id<T> id, Change<T> change);
}
