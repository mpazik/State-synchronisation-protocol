package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Change;

/**
 * The command pattern is used as the method should be stateless.
 * No stateful component shouldn't be require so there is no need for dependency injection.
 */
public interface UpdateChange<T extends Entity<T>> extends Change<T> {
    void updateEntityState(T entity);
}
