package Exceptions;

/**
 * @author KAWAIISHY
 * @project paps-unit-tests
 * @created 01.04.2022
 */

public class NullFieldException extends Exception{
    public NullFieldException() {}

    public NullFieldException(String message) {
        super(message);
    }

    public NullFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullFieldException(Throwable cause) {
        super(cause);
    }

    public NullFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
