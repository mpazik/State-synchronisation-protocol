package pl.marekpazik.state_synchronisation.component.store;

import com.google.common.collect.ImmutableMap;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityFactory;
import pl.marekpazik.state_synchronisation.entity.EntityType;

import java.util.HashMap;

public final class EntityFactoryRegistry {
    private final ImmutableMap<EntityType<?>, EntityFactory<?>> factories;

    private EntityFactoryRegistry(ImmutableMap<EntityType<?>, EntityFactory<?>> factories) {
        this.factories = factories;
    }

    public <T extends Entity<T>> EntityFactory<T> get(EntityType<T> entityType) {
        //noinspection unchecked
        EntityFactory<T> entityFactory = (EntityFactory<T>) factories.get(entityType);
        assert entityFactory != null;
        return entityFactory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        HashMap<EntityType<?>, EntityFactory<?>> factories = new HashMap<>();

        private Builder() {
        }

        public <T extends Entity<T>> Builder addEntityFactory(EntityType<T> entityType, EntityFactory<?> entityFactory) {
            factories.put(entityType, entityFactory);
            return this;
        }

        public EntityFactoryRegistry build() {
            return new EntityFactoryRegistry(ImmutableMap.copyOf(factories));
        }
    }
}
