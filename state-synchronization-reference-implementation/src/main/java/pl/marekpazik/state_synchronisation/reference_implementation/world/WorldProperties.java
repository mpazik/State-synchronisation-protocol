package pl.marekpazik.state_synchronisation.reference_implementation.world;

import pl.marekpazik.state_synchronisation.entity.Entity;

public class WorldProperties implements Entity.Properties<World> {
    public final int weight;
    public final int height;

    public WorldProperties(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}
