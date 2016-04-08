package pl.marekpazik.state_synchronisation.entity;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public abstract class EntityStoreTest<T extends Entity<T>> {
    EntityStore entityStore;

    @Before
    public void setUp() throws Exception {
        entityStore = createSut();
    }

    @Test
    public void getEntity_ifExists_returnsIt() {
        Entity.Id<T> id = generateId();
        CreationChange<T> creationChange = getCreationChange();
        entityStore.saveChange(id, creationChange);

        T entity = entityStore.getEntity(id);

        assertThat(entity).isNotNull();
    }

    @Test
    public void getEntity_ifNotExists_throwsAnException() {
        Throwable thrown = catchThrowable(() -> entityStore.getEntity(generateId()));

        assertThat(thrown).isNotNull();

    }

    protected abstract EntityStore createSut();

    protected abstract Entity.Id<T> generateId();

    protected abstract CreationChange<T> getCreationChange();

}