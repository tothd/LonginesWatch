package hu.unideb.inf.tothd.services;

import hu.unideb.inf.tothd.model.Watch;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WatchSearchBySerialNumber {
    private static String SEARCH_URI = "http://shop.us.longines.com/catalogsearch/result/?q=";

    public WatchSearchBySerialNumber() {
    }

    public Watch doSearch(String serialNumber) throws IOException {
        String url =SEARCH_URI+serialNumber;
        Document doc = Jsoup.connect(url).userAgent("Mozzila").get();

        String link = doc.select("div.product-grid-container > a").get(0).attr("abs:href");
        SingleWatchService singleWatchService = new SingleWatchService();
        return singleWatchService.find(link.replace("http://shop.us.longines.com",""));
    }

}
