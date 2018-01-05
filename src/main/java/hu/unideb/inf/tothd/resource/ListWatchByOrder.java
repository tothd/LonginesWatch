package hu.unideb.inf.tothd.resource;

import hu.unideb.inf.tothd.model.SearchResults;
import hu.unideb.inf.tothd.services.WatchListOderBy;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.IOException;

public class ListWatchByOrder extends ServerResource {
    @Get("json|xml")
    public SearchResults represent() throws IOException {
        String direction = getAttribute("direction");
        String order = getAttribute("order");

        WatchListOderBy watchListOderBy = new WatchListOderBy();


        SearchResults result = watchListOderBy.doList(direction, order);
        if (result==null){
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        return result;
    }
}
