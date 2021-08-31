package challenge.disney.exception;

import java.text.MessageFormat;

public class MovieIsAlreadyAssignedException extends RuntimeException {
    public MovieIsAlreadyAssignedException(final Long movieId, final Long characterId) {
        super(MessageFormat.format("Movie: {0} is already assigned to character: {1}",movieId,characterId));

    }
}
