package hu.unideb.inf.tothd.parser;

import hu.unideb.inf.tothd.model.Price;
import hu.unideb.inf.tothd.model.SearchResultItem;
import hu.unideb.inf.tothd.model.SearchResults;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class WatchSearchResultParser {

    private static final String currency = "USD";

    public static final int MAX_ITEMS = 60;

    private int maxItems = MAX_ITEMS;

    public WatchSearchResultParser() {
    }

    public WatchSearchResultParser(int maxItems) {
        setMaxItems(maxItems);
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    private int getTotalItems(Document doc) throws IOException {
        if (doc.select("p.note.msg").text().equals("Your search returns no results.")) {
            return 0;
        }
        int totalItems = 0;
        try {
            totalItems = Integer.parseInt(doc.select("p.amount").first().text().replaceAll("\\D+", ""));
        } catch (Exception e) {
            throw new IOException("Malformed document");
        }
        return totalItems;
    }

    public SearchResults parse(Document doc) throws IOException {
        SearchResults searchResults = new SearchResults();
        searchResults.setItemsTotal(getTotalItems(doc));
        searchResults.setItems(extractItems(doc));
        return searchResults;
    }

    private List<SearchResultItem> extractItems(Document doc) throws IOException {
        List<SearchResultItem> items = new LinkedList<SearchResultItem>();
        SearchResultItem searchResultItem = new SearchResultItem();

        Elements elements = doc.select("div.category-products > div.product-grid-container");
        for (Element e : elements) {
            String productTitle = e.select("span.product-title").first().text();
            searchResultItem.setProductTitle(productTitle);

            String productSubtitle = e.select("span.product-subtitle").first().text();
            searchResultItem.setProductSubtitle(productSubtitle);

            Price price = new Price(
                    new BigDecimal(e.select("span.price").first().text().replaceAll("[^\\d.-]", "")), currency);
            searchResultItem.setPrice(price);

            items.add(searchResultItem);
        }
        return items;
    }
}
