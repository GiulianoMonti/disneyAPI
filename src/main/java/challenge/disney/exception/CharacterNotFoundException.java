package challenge.disney.exception;

import java.text.MessageFormat;

public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException(final Long id){
        super(MessageFormat.format("Could not find character with id: {0}",id));
    }
}
