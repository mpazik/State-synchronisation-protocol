package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.reference_implementation.Position;
import pl.marekpazik.state_synchronisation.reference_implementation.character.GameCharacter.Properties;
import pl.marekpazik.state_synchronisation.reference_implementation.character.GameCharacter.State;

public class CharacterMoved extends CharacterUpdateChange {
    public final Position newPosition;

    public CharacterMoved(Position newPosition) {
        this.newPosition = newPosition;
    }

    @Override
    public State calculateNewState(Properties properties, State state) {
        return new State(newPosition);
    }
}
