package pl.marekpazik.state_synchronisation.reference_implementation.world;

import pl.marekpazik.state_synchronisation.Change;

public final class WorldObjectCreated implements Change<World> {
    public final WorldObject worldObject;

    public WorldObjectCreated(WorldObject worldObject) {
        this.worldObject = worldObject;
    }
}
