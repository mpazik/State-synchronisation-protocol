package pl.marekpazik.state_synchronisation.reference_implementation.character;

import pl.marekpazik.state_synchronisation.reference_implementation.Position;

public class CharacterMoved extends CharacterUpdateChange {
    public final Position newPosition;

    public CharacterMoved(Position newPosition) {
        this.newPosition = newPosition;
    }

    @Override
    public CharacterState calculateNewState(CharacterProperties properties, CharacterState state) {
        return new CharacterState(newPosition);
    }
}
