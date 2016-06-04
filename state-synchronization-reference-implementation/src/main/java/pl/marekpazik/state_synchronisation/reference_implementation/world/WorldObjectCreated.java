package pl.marekpazik.state_synchronisation.reference_implementation.world;

import com.google.common.collect.ImmutableSet;

public final class WorldObjectCreated extends WordUpdateChange {
    public final WorldObject worldObject;

    public WorldObjectCreated(WorldObject worldObject) {
        this.worldObject = worldObject;
    }

    @Override
    public WorldState calculateNewState(WorldProperties properties, WorldState state) {
        ImmutableSet<WorldObject> worldObjects = ImmutableSet.<WorldObject>builder()
                .addAll(state.worldObjects)
                .add(worldObject)
                .build();
        return new WorldState(worldObjects);
    }
}
