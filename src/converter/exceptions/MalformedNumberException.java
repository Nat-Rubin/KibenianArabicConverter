package converter.exceptions;

/**
 * Exception that is thrown when a string that should represent a number (Arabic or Kibenian) is malformed.
 *
 * @version 3/31/2023
 */
public class MalformedNumberException extends Exception {

    /**
     * Constructor with a description message for the malformed number Exception.
     *
     * @param message A description of the error
     */
    public MalformedNumberException(String message) {
        super(message);
    }

}
