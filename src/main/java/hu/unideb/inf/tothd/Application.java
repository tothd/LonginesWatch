package hu.unideb.inf.tothd;

import hu.unideb.inf.tothd.resource.*;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class Application extends org.restlet.Application {
    static {
        System.setProperty("org.restlet.engine.loggerFacadeClass", "org.restlet.ext.slf4j.Slf4jLoggerFacade");
    }

    private static final String PATH = "http://localhost";
    private static final int PORT = 8888;

    public static void main(String[] args) {
        Server server = new Server(Protocol.HTTP, 8888, new Application());
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restlet createInboundRoot() {
        IMRouter router = new IMRouter(getContext(), PATH, PORT);
        router.attach("/watch?name={name}", SingleWatchByName.class);
        router.attach("/watchSearch?sn={serialNumber}", SingleWatchBySerialNumber.class);
        router.attach("/watchList?term={term}", ListWatchBySearchTerm.class);
        router.attach("/watchList?dir={direction}&order={order}", ListWatchByOrder.class);
        router.attach("/watchList?limit={limit}&p={page}", ListWatchByLimitAndPage.class);
        return router.getRouter();
    }
}
