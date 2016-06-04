package pl.marekpazik.state_synchronisation.component.store;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.ChangesStore;
import pl.marekpazik.state_synchronisation.entity.Changes;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityStore;

/**
 * Entity store that base on {@link Changes}. All saved changes are saved in the {@link ChangesStore}.
 * @see ChangesStore#saveChange(Entity.Id, Change) ChangesStore#saveChange
 */
public final class BuildingFromChangesEntityStore implements EntityStore {
    private final ChangesStore changesStore;

    public BuildingFromChangesEntityStore(ChangesStore changesStore) {
        this.changesStore = changesStore;
    }

    @Override
    public <T extends Entity<T>> T getEntity(Entity.Id<T> id) {
        Changes<T> changes = changesStore.getAllChanges(id);
        T entity = changes.getCreationChange().createEntity(id);
        changes.getUpdateChanges().forEach(change -> change.updateEntityState(entity));
        return entity;
    }

    @Override
    public <T extends Entity<T>> void saveChange(Entity.Id<T> id, Change<T> change) {
        changesStore.saveChange(id, change);
    }
}
