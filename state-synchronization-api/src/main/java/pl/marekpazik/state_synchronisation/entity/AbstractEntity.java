package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Version;

public abstract class AbstractEntity<
        E extends Entity<E>,
        P extends Entity.Properties<E>,
        S extends Entity.State<E>
        > implements Entity<E> {
    private final Id<E> id;
    private final P properties;
    private Version version;
    private S state;

    public AbstractEntity(Id<E> id, P properties, S state) {
        this.id = id;
        this.version = Version.first();
        this.properties = properties;
        this.state = state;
    }

    @Override
    public Id<E> getId() {
        return id;
    }

    @Override
    public S getState() {
        return state;
    }

    public void updateState(S newState) {
        state = newState;
        version = version.next();
    }

    @Override
    public Version getVersion() {
        return version;
    }

    @Override
    public P getProperties() {
        return properties;
    }
}
