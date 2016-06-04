package pl.marekpazik.state_synchronisation.reference_implementation.world;

import pl.marekpazik.state_synchronisation.common.Id;
import pl.marekpazik.state_synchronisation.entity.AbstractEntity;
import pl.marekpazik.state_synchronisation.entity.EntityProperties;
import pl.marekpazik.state_synchronisation.entity.EntityState;
import pl.marekpazik.state_synchronisation.entity.EntityType;
import pl.marekpazik.state_synchronisation.reference_implementation.StringEntityType;

import java.util.Set;

public class World extends AbstractEntity<World, World.Properties, World.State> {

    public static EntityType<World> entityType = new StringEntityType<>("world");

    public World(Id<World> id, Properties properties, State state) {
        super(id, properties, state);
    }

    public static class Properties implements EntityProperties<World> {
        public final int weight;
        public final int height;

        public Properties(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static class State implements EntityState<World> {
        public final Set<WorldObject> worldObjects;

        public State(Set<WorldObject> worldObjects) {
            this.worldObjects = worldObjects;
        }
    }
}