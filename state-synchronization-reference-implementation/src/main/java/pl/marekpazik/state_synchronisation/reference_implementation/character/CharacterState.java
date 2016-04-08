package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.entity.Entity;
import pl.marekpazik.state_synchronisation.reference_implementation.Position;

public final class CharacterState implements Entity.State<GameCharacter> {
    public final Position position;

    public CharacterState(Position position) {
        this.position = position;
    }
}
