package pl.marekpazik.state_synchronisation.component.store;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.ChangesStore;
import pl.marekpazik.state_synchronisation.common.Id;
import pl.marekpazik.state_synchronisation.entity.Changes;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityStore;

/**
 * Entity store that base on {@link Changes}. All saved changes are saved in the {@link ChangesStore}.
 * @see ChangesStore#saveChange(Id, Change) ChangesStore#saveChange
 */
public final class BuildingFromChangesEntityStore implements EntityStore {
    private final ChangesStore changesStore;

    public BuildingFromChangesEntityStore(ChangesStore changesStore) {
        this.changesStore = changesStore;
    }

    @Override
    public <E extends Entity<E>> E getEntity(Id<E> id) {
        Changes<E> changes = changesStore.getAllChanges(id);
        E entity = changes.getCreationChange().createEntity(id);
        changes.getUpdateChanges().forEach(change -> change.updateEntityState(entity));
        return entity;
    }

    @Override
    public <E extends Entity<E>> void saveChange(Id<E> id, Change<E> change) {
        changesStore.saveChange(id, change);
    }
}
