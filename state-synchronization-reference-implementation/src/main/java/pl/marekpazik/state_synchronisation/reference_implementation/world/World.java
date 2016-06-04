package pl.marekpazik.state_synchronisation.reference_implementation.world;

import pl.marekpazik.state_synchronisation.entity.AbstractEntity;
import pl.marekpazik.state_synchronisation.entity.EntityType;
import pl.marekpazik.state_synchronisation.reference_implementation.StringEntityType;

public class World extends AbstractEntity<World, WorldProperties, WorldState> {

    public static EntityType<World> entityType = new StringEntityType<>("world");

    public World(Id<World> id, WorldProperties properties, WorldState state) {
        super(id, properties, state);
    }
}