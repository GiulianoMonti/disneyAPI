package challenge.disney.exception;

import java.text.MessageFormat;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(final Long id){
        super(MessageFormat.format("Could not find movie with id: {0}",id));
    }
}
