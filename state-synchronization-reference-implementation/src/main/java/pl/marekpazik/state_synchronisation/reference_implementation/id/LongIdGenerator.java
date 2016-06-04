package pl.marekpazik.state_synchronisation.reference_implementation.id;

import pl.marekpazik.state_synchronisation.common.Id;
import pl.marekpazik.state_synchronisation.entity.Entity;

public class LongIdGenerator {
    private long lastId = 0;

    public <E extends Entity<E>> Id<E> generateId() {
        lastId += 1;
        return new LongId<>(lastId);
    }
}
