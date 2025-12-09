package exception;

public class StopsInfoEmptyException extends RuntimeException {
    public StopsInfoEmptyException() {
        super("STOPS_INFO_EMPTY_EXCEPTION");
    }
}
