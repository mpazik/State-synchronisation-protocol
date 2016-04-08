package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.Version;
import pl.marekpazik.state_synchronisation.entity.AbstractEntity;
import pl.marekpazik.state_synchronisation.entity.EntityType;
import pl.marekpazik.state_synchronisation.reference_implementation.StringEntityType;

import static com.nurkiewicz.typeof.TypeOf.whenTypeOf;

public final class GameCharacter extends AbstractEntity<GameCharacter, CharacterProperties, CharacterState> {

    public static EntityType<GameCharacter> entityType = new StringEntityType<>("character");

    public GameCharacter(Id<GameCharacter> id, Version version, CharacterProperties properties, CharacterState state) {
        super(id, version, properties, state);
    }

    @Override
    public void applyChange(Change<GameCharacter> change) {
        whenTypeOf(change)
                .is(CharacterMoved.class)
                .then((characterMoved) -> updateState(new CharacterState(characterMoved.newPosition)));
    }

    public enum CharacterType {
        Player,
        Mob
    }
}
