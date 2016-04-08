package pl.marekpazik.state_synchronisation;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import pl.marekpazik.state_synchronisation.entity.Changes;
import pl.marekpazik.state_synchronisation.entity.CreationChange;
import pl.marekpazik.state_synchronisation.entity.Entity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public abstract class ChangesStoreTest<T extends Entity<T>> {
    ChangesStore changesStore;

    @Before
    public void setUp() throws Exception {
        changesStore = createSut();
    }

    @Test
    public void getAllChanges_returnsAllChangesInOrder() {
        Entity.Id<T> id = generateId();
        CreationChange<T> creationChange = getCreationChange();
        Change<T> change = getChange();
        changesStore.saveChange(id, creationChange);
        changesStore.saveChange(id, change);

        Changes<T> changes = changesStore.getAllChanges(id);

        List<Change<T>> asList = changes.getAsList();

        assertThat(asList).containsExactlyElementsOf(ImmutableList.of(creationChange, change));
    }

    @Test
    public void getAllChanges_anyChangeForEntity_throwsExceptionAtSomePoint() {
        Throwable thrown = catchThrowable(() -> {
            Changes<T> changes = changesStore.getAllChanges(generateId());
            changes.getCreationChange();
        });

        assertThat(thrown).isNotNull();

    }

    @Test
    public void getAllChanges_anyCreatingChangeIsNotFirst_throwsExceptionAtSomePoint() {
        Throwable thrown = catchThrowable(() -> {
            Entity.Id<T> id = generateId();
            changesStore.saveChange(id, getChange());
            Changes<T> changes = changesStore.getAllChanges(id);
            changes.getCreationChange();
        });

        assertThat(thrown).isNotNull();
    }

    protected abstract Entity.Id<T> generateId();

    protected abstract ChangesStore createSut();

    protected abstract CreationChange<T> getCreationChange();

    protected abstract Change<T> getChange();
}