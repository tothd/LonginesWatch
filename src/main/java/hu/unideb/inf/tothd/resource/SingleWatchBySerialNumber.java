package hu.unideb.inf.tothd.resource;

import hu.unideb.inf.tothd.model.Watch;
import hu.unideb.inf.tothd.services.WatchSearchBySerialNumber;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.IOException;

public class SingleWatchBySerialNumber extends ServerResource{

    @Get("json|xml")
    public Watch represent() throws IOException {
        String serialNumber = getAttribute("serialNumber");
        WatchSearchBySerialNumber watchSearchBySerialNumber = new WatchSearchBySerialNumber();

            Watch watch = watchSearchBySerialNumber.doSearch(serialNumber);
            if (watch==null){
                throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
            }
            return watch;
    }
}
