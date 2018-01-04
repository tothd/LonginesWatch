package hu.unideb.inf.tothd.services;

import hu.unideb.inf.tothd.model.SearchResults;
import hu.unideb.inf.tothd.parser.WatchSearchResultParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class SimpleSearch extends WatchSearchResultParser {

    private static final String SEARCH_URI = "http://shop.us.longines.com/catalogsearch/result/?q=";

    public SimpleSearch() {
    }

    public SimpleSearch(int maxItems) {
        super(maxItems);
    }

    public SearchResults doSearch(String query) throws IOException {
        String url = SEARCH_URI + query;
        Document doc = Jsoup.connect(url).userAgent("Mozzila").get();
        return parse(doc);
    }

    private static void printHelpAndExit(int status) {
        System.err.printf("Usage: java %s [--limit <integer>] <term>\n", SimpleSearch.class.getName());
        System.exit(status);
    }
}
