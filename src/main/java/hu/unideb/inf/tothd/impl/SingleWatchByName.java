package hu.unideb.inf.tothd.impl;

import hu.unideb.inf.tothd.model.Watch;
import hu.unideb.inf.tothd.services.SingleWatchService;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.IOException;

public class SingleWatchByName extends ServerResource {
    private final static String WATCH_URI = "/watch-selector/men/";

    @Get("json|xml")
    public Watch represent() {
        String watchName = getAttribute("name");

        SingleWatchService singleWatchService = new SingleWatchService();

        try {
            return singleWatchService.doSearch(WATCH_URI + watchName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
    }
}
