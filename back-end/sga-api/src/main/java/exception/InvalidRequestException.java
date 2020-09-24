package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends BusinessException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8095678136423249983L;

	public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Throwable ex) {
        super(message, ex);
    }

}
