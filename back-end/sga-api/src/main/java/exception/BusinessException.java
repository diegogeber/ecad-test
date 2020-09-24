package exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -6370862692818098623L;

	public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
