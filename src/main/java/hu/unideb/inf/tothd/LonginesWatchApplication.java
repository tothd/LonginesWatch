package hu.unideb.inf.tothd;

import hu.unideb.inf.tothd.impl.SingleWatchByName;
import hu.unideb.inf.tothd.impl.SingleWatchBySerialNumber;
import hu.unideb.inf.tothd.router.IMRouter;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class LonginesWatchApplication extends Application {
    static {
        System.setProperty("org.restlet.engine.loggerFacadeClass", "org.restlet.ext.slf4j.Slf4jLoggerFacade");
    }

    private static final String PATH = "http://localhost";
    private static final int PORT = 8888;

    public static void main(String[] args) {
        Server server = new Server(Protocol.HTTP, 8888, new LonginesWatchApplication());
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restlet createInboundRoot() {
        IMRouter router = new IMRouter(getContext(), PATH, PORT);
        router.attach("/watch-selector/men/{name}", SingleWatchByName.class);
        router.attach("/watchSearch?sn={serialNumber}", SingleWatchBySerialNumber.class);
        return router.getRouter();
    }


}
