package hu.unideb.inf.tothd.resource;

import hu.unideb.inf.tothd.model.Watch;
import hu.unideb.inf.tothd.services.SingleWatchService;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.IOException;

public class SingleWatchByName extends ServerResource {
    private final static String WATCH_URI = "/watch-selector/";

    @Get("json|xml")
    public Watch represent() throws IOException {
        String watchName = getAttribute("name");

        SingleWatchService singleWatchService = new SingleWatchService();

        Watch watch =singleWatchService.find(WATCH_URI + watchName);

        if (watch==null){
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        return watch;
    }
}
