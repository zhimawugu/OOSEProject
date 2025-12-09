package exception;

public class RouteNameEmptyException extends RuntimeException {
    public RouteNameEmptyException() {
        super("ROUTE_NAME_EMPTY_EXCEPTION");
    }
}
