package hu.unideb.inf.tothd.services;

import hu.unideb.inf.tothd.model.Watch;
import hu.unideb.inf.tothd.parser.WatchParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import java.io.IOException;

public class SingleWatchService {
    private static String SHOP_URI = "http://shop.us.longines.com";

    public SingleWatchService() {
    }

    public Watch find(String href) throws IOException {
        String url = SHOP_URI + href;
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozzila").get();
        }catch (Exception e){
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        WatchParser wp = new WatchParser();
        Watch watch = wp.parse(url);

        if (watch==null){
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        return watch;
    }
}
