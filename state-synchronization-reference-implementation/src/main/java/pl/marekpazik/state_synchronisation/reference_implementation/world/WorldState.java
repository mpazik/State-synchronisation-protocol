package pl.marekpazik.state_synchronisation.reference_implementation.world;

import pl.marekpazik.state_synchronisation.entity.Entity;

import java.util.Set;

public class WorldState implements Entity.State<World> {
    public final Set<WorldObject> worldObjects;

    public WorldState(Set<WorldObject> worldObjects) {
        this.worldObjects = worldObjects;
    }
}
