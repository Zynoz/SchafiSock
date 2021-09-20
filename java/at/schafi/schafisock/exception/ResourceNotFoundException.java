/* (C)2021 */
package at.schafi.schafisock.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -5243742295908109577L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }

    public ResourceNotFoundException(final Throwable cause) {
        super(cause);
    }
}
