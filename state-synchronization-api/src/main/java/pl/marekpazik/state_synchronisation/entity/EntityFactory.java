package pl.marekpazik.state_synchronisation.entity;

/**
 * Creates entity of a given type from a {@link CreationChange}.
 * Produced entity has only ony the initial state.
 */
public interface EntityFactory<T extends Entity<T>> {

    T createEntity(CreationChange<T> creationChange);
}
