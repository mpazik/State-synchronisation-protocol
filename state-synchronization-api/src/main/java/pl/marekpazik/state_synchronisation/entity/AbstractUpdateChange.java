package pl.marekpazik.state_synchronisation.entity;

/**
 * An change that change the state of the entity.
 * @param <T> type of an entity
 */

public abstract class AbstractUpdateChange<T extends AbstractEntity<T, P, S>,
        P extends Entity.Properties<T>,
        S extends Entity.State<T>
        > implements UpdateChange<T> {

    @Override
    public final void updateEntityState(T entity) {
        S newState = calculateNewState(entity.getProperties(), entity.getState());
        entity.updateState(newState);
    }

    public abstract S calculateNewState(P properties, S state);
}

