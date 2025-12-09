import entity.Route;
import exception.RouteNameEmptyException;
import exception.StopsInfoEmptyException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import service.RouteService;
import service.StopService;


public class RouteServiceTest {

    @Test
    void testCreateRouteSuccess() {
        StopService stopService = new StopService();
        RouteService routeService = new RouteService(stopService);

        String routeName = "Route 1";
        String[] stops = {"Stop A", "Stop B"};

        Route route = routeService.createRoute(routeName, stops);

        Assertions.assertEquals("Route 1", route.getName());
        Assertions.assertEquals(2, route.getStops().size());
        Assertions.assertEquals("Stop A", route.getStops().get(0).getStopName());
    }

    @Test
    void testCreateRoute_EmptyRouteName() {
        StopService stopService = new StopService();
        RouteService routeService = new RouteService(stopService);

        Assertions.assertThrows(RouteNameEmptyException.class, () -> {
            routeService.createRoute("", new String[]{"Stop A"});
        });
    }

    @Test
    void testCreateRoute_EmptyStopsInfo() {
        StopService stopService = new StopService();
        RouteService routeService = new RouteService(stopService);

        Assertions.assertThrows(StopsInfoEmptyException.class, () -> {
            routeService.createRoute("Route 1", new String[] {});
        });
    }
}