package pl.marekpazik.state_synchronisation.reference_implementation.world;

import com.google.common.collect.ImmutableSet;
import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.Version;
import pl.marekpazik.state_synchronisation.entity.AbstractEntity;
import pl.marekpazik.state_synchronisation.entity.EntityType;
import pl.marekpazik.state_synchronisation.reference_implementation.StringEntityType;

import static com.nurkiewicz.typeof.TypeOf.whenTypeOf;

public class World extends AbstractEntity<World, WorldProperties, WorldState> {

    public static EntityType<World> entityType = new StringEntityType<>("world");

    public World(Id<World> id, Version version, WorldProperties properties, WorldState state) {
        super(id, version, properties, state);
    }

    @Override
    public void applyChange(Change<World> change) {
        whenTypeOf(change)
                .is(WorldObjectCreated.class)
                .then((worldObjectCreated) -> {
                    ImmutableSet<WorldObject> worldObjects = ImmutableSet.<WorldObject>builder()
                            .addAll(getState().worldObjects)
                            .add(worldObjectCreated.worldObject)
                            .build();
                    updateState(new WorldState(worldObjects));
                });
    }
}