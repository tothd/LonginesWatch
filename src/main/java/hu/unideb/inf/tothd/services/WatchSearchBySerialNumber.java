package hu.unideb.inf.tothd.services;

import hu.unideb.inf.tothd.model.Watch;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import java.io.IOException;

import static javafx.beans.binding.Bindings.select;

public class WatchSearchBySerialNumber {
    private static String SEARCH_URI = "http://shop.us.longines.com/catalogsearch/result/?q=";

    public WatchSearchBySerialNumber() {
    }

    public Watch doSearch(String serialNumber) throws IOException {
        String url =SEARCH_URI+serialNumber;
        Document doc = Jsoup.connect(url).userAgent("Mozzila").get();

        Elements elements = doc.select("div.product-grid-container > a");

        if (elements.isEmpty()){
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        String link = elements.get(0).attr("abs:href");
        SingleWatchService singleWatchService = new SingleWatchService();
        Watch watch =singleWatchService.find(link.replace("http://shop.us.longines.com",""));

        if (watch==null){
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        return watch;
    }

}
