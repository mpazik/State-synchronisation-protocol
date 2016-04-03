package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.Version;
import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.entity.EntityType;
import pl.marekpazik.state_synchronisation.reference_implementation.Position;
import pl.marekpazik.state_synchronisation.reference_implementation.StringEntityType;

import static com.nurkiewicz.typeof.TypeOf.whenTypeOf;

public class Character implements Entity<Character> {
    private final Id<Character> id;
    private final CharacterProperties properties;
    private Version version;
    private CharacterState state;

    public static EntityType<Character> entityType = new StringEntityType<>("character");

    public Character(Id<Character> id, Version version, CharacterProperties properties, CharacterState state) {
        this.id = id;
        this.version = version;
        this.properties = properties;
        this.state = state;
    }

    @Override
    public Id<Character> getId() {
        return id;
    }

    @Override
    public CharacterState getState() {
        return state;
    }

    @Override
    public void applyChange(Change<Character> change) {
        whenTypeOf(change)
                .is(CharacterMoved.class)
                .then((characterMoved) -> {
                    state = new CharacterState(characterMoved.newPosition);
                    version = version.next();
                });
    }

    @Override
    public Version getVersion() {
        return version;
    }

    @Override
    public CharacterProperties getProperties() {
        return properties;
    }

    public static final class CharacterProperties implements Properties<Character> {
        public final String name;
        public final CharacterType characterType;

        public CharacterProperties(String name, CharacterType characterType) {
            this.name = name;
            this.characterType = characterType;
        }
    }

    public static final class CharacterState implements State<Character> {
        public final Position position;

        public CharacterState(Position position) {
            this.position = position;
        }


    }

    public enum CharacterType {
        Player,
        Mob
    }
}
