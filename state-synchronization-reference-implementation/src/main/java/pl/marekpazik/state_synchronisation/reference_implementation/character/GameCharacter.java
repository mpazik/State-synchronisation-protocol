package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.common.Id;
import pl.marekpazik.state_synchronisation.entity.*;
import pl.marekpazik.state_synchronisation.reference_implementation.Position;
import pl.marekpazik.state_synchronisation.reference_implementation.StringEntityType;

public final class GameCharacter extends AbstractEntity<GameCharacter, GameCharacter.Properties, GameCharacter.State> {

    public static EntityType<GameCharacter> entityType = new StringEntityType<>("character");

    public GameCharacter(Id<GameCharacter> id, Properties properties, State state) {
        super(id, properties, state);
    }

    public enum GameCharacterType {
        Player,
        Mob
    }

    public static final class Properties implements EntityProperties<GameCharacter> {
        public final String name;
        public final GameCharacterType gameCharacterType;

        public Properties(String name, GameCharacterType gameCharacterType) {
            this.name = name;
            this.gameCharacterType = gameCharacterType;
        }
    }

    public static final class State implements EntityState<GameCharacter> {
        public final Position position;

        public State(Position position) {
            this.position = position;
        }
    }
}
