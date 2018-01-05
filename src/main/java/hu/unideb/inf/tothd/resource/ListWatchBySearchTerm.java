package hu.unideb.inf.tothd.resource;

import hu.unideb.inf.tothd.model.SearchResults;
import hu.unideb.inf.tothd.services.SimpleSearch;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.IOException;

public class ListWatchBySearchTerm extends ServerResource {


    @Get("json|xml")
    public SearchResults represent() throws IOException {
        String term = getAttribute("term");

        SimpleSearch simpleSearch = new SimpleSearch();

        SearchResults result = simpleSearch.doSearch(term);

        if (result==null){
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        return result;
    }
}
