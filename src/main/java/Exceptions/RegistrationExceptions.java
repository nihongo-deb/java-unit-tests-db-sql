package Exceptions;

/**
 * @author KAWAIISHY
 * @project paps-unit-tests
 * @created 01.04.2022
 */

public class RegistrationExceptions extends Exception{
    public RegistrationExceptions() {
    }

    public RegistrationExceptions(String message) {
        super(message);
    }

    public RegistrationExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistrationExceptions(Throwable cause) {
        super(cause);
    }

    public RegistrationExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
