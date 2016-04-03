package pl.marekpazik.state_synchronisation.reference_implementation.id;

import pl.marekpazik.state_synchronisation.entity.Entity;

public class LongIdGenerator {
    private long lastId = 0;

    public <T extends Entity<T>> Entity.Id<T> generateId() {
        lastId += 1;
        return new LongId<>(lastId);
    }
}
