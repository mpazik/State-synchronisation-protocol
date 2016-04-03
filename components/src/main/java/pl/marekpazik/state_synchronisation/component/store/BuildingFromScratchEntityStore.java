package pl.marekpazik.state_synchronisation.component.store;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.ChangesStore;
import pl.marekpazik.state_synchronisation.entity.EntityFactory;
import pl.marekpazik.state_synchronisation.entity.EntityType;
import pl.marekpazik.state_synchronisation.entity.Changes;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityStore;

/**
 * Entity store that base on {@link Changes}. All saved changes are saved in the {@link ChangesStore}.
 * @see ChangesStore#saveChange(Entity.Id, Change) ChangesStore#saveChange
 */
public final class BuildingFromScratchEntityStore implements EntityStore {
    private final EntityFactoryRegistry entityFactoryRegistry;
    private final ChangesStore changesStore;

    public BuildingFromScratchEntityStore(EntityFactoryRegistry entityFactoryRegistry, ChangesStore changesStore) {
        this.entityFactoryRegistry = entityFactoryRegistry;
        this.changesStore = changesStore;
    }

    @Override
    public <T extends Entity<T>> T getEntity(Entity.Id<T> id) {
        Changes<T> changes = changesStore.getAllChanges(id);
        EntityType<T> entityType = changes.getCreationChange().getEntityType();
        EntityFactory<T> entityFactory = entityFactoryRegistry.get(entityType);
        T entity = entityFactory.createEntity(changes.getCreationChange());
        changes.getChanges().forEach(entity::applyChange);
        return entity;
    }

    @Override
    public <T extends Entity<T>> void saveChange(Entity.Id<T> id, Change<T> change) {
        changesStore.saveChange(id, change);
    }
}
