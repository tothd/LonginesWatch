package hu.unideb.inf.tothd.services;

import hu.unideb.inf.tothd.model.SearchResults;
import hu.unideb.inf.tothd.parser.SearchResultParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WatchListOderBy {

    private static String LIST_URI = "http://shop.us.longines.com/longines-collections.html";

    public WatchListOderBy() {
    }

    public SearchResults doList(String direction, String order) throws IOException {
        String url =LIST_URI+"?dir="+direction+"&order="+order;
        Document doc = Jsoup.connect(url).userAgent("Mozzila").get();

        SearchResultParser searchResultParser = new SearchResultParser();
        return searchResultParser.parse(doc);
    }
}
