package pl.marekpazik.state_synchronisation.component.store;

import com.google.common.cache.Cache;
import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityStore;
import pl.marekpazik.state_synchronisation.entity.UpdateChange;

import java.util.concurrent.ExecutionException;

public final class CachedEntityStore implements EntityStore {
    private final EntityStore entityStore;
    private final Cache<Entity.Id<?>, Entity<?>> cache;

    public CachedEntityStore(EntityStore entityStore, Cache<Entity.Id<?>, Entity<?>> cache) {
        this.entityStore = entityStore;
        this.cache = cache;
    }

    @Override
    public <E extends Entity<E>> E getEntity(Entity.Id<E> id) {
        try {
            //noinspection unchecked
            return (E) cache.get(id, () -> entityStore.getEntity(id));
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <E extends Entity<E>> void saveChange(Entity.Id<E> id, Change<E> change) {
        //noinspection unchecked
        E entity = (E) cache.getIfPresent(id);
        if (entity != null && change instanceof UpdateChange) {
            ((UpdateChange<E>) change).updateEntityState(entity);
        }
        entityStore.saveChange(id, change);
    }
}
