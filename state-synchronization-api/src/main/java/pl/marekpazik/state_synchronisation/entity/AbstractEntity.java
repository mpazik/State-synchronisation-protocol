package pl.marekpazik.state_synchronisation.entity;

import pl.marekpazik.state_synchronisation.Version;

public abstract class AbstractEntity<
        T extends Entity<T>,
        P extends Entity.Properties<T>,
        S extends Entity.State<T>
        > implements Entity<T> {
    private final Id<T> id;
    private final P properties;
    private Version version;
    private S state;

    public AbstractEntity(Id<T> id, P properties, S state) {
        this.id = id;
        this.version = Version.first();
        this.properties = properties;
        this.state = state;
    }

    @Override
    public Id<T> getId() {
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
