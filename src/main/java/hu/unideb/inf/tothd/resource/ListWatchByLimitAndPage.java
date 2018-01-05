package hu.unideb.inf.tothd.resource;


import hu.unideb.inf.tothd.model.SearchResults;
import hu.unideb.inf.tothd.services.WatchList;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.IOException;


public class ListWatchByLimitAndPage extends ServerResource {
    @Get("json|xml")
    public SearchResults represent() throws IOException {
        String page = getAttribute("page");
        String limit = getAttribute("limit");

        if (page == null || limit == null) {
            WatchList watchList = new WatchList();
            try {
                return watchList.doList("32", "1");
            } catch (IOException e) {
                throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
            }
        }

        WatchList watchList = new WatchList();

        SearchResults result = watchList.doList(limit, page);
        if (result == null) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        return result;
    }
}
