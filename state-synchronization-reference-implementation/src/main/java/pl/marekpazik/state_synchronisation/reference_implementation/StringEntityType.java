package pl.marekpazik.state_synchronisation.reference_implementation;

import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityType;

import java.util.Objects;

public class StringEntityType<E extends Entity<E>> implements EntityType<E> {
    private final String type;

    public StringEntityType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringEntityType<?> that = (StringEntityType<?>) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
