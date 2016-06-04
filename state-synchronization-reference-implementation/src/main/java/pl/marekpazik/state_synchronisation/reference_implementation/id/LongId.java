package pl.marekpazik.state_synchronisation.reference_implementation.id;

import pl.marekpazik.state_synchronisation.common.Id;

import java.util.Objects;

public class LongId<T> implements Id<T> {
    private final long id;

    public LongId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongId<?> longId = (LongId<?>) o;
        return Objects.equals(id, longId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
