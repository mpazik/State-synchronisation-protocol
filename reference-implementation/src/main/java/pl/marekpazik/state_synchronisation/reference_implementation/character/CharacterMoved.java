package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.Change;
import pl.marekpazik.state_synchronisation.reference_implementation.Position;

public class CharacterMoved implements Change<GameCharacter> {
    public final Position newPosition;

    public CharacterMoved(Position newPosition) {
        this.newPosition = newPosition;
    }
}
