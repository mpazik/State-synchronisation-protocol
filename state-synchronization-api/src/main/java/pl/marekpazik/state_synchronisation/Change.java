package pl.marekpazik.state_synchronisation;

import pl.marekpazik.state_synchronisation.entity.Entity;

/**
 * An change that change the state of the entity.
 * @param <E> type of an entity
 */

public interface Change<E extends Entity<E>> {
}

