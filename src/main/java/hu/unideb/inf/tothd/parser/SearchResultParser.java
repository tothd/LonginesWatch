package hu.unideb.inf.tothd.parser;

import hu.unideb.inf.tothd.model.Price;
import hu.unideb.inf.tothd.model.SearchResultItem;
import hu.unideb.inf.tothd.model.SearchResults;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class SearchResultParser {

    private static final String currency = "USD";

    public static final int MAX_ITEMS = 60;
    public static final int FROM = 1;
    public static final int MAXIMUM_WATCH_IN_ONE_PAGE = 36;

    private int maxItems = MAX_ITEMS;

    public SearchResultParser() {
    }

    public SearchResultParser(int maxItems) {
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
            String amount = doc.select("p.amount").first().text();
            if (amount.contains("of")) {
                totalItems = Integer.parseInt(amount.substring(amount.length() - 3).trim());
            } else {
                totalItems = Integer.parseInt(amount.replaceAll("\\D+", ""));
            }
        } catch (Exception e) {
            throw new IOException("Malformed document");
        }
        return totalItems;
    }

    public SearchResults parse(Document doc) throws IOException {
        int totalItems = getTotalItems(doc);

        SearchResults searchResults = new SearchResults();
        searchResults.setItemsTotal(totalItems);
        searchResults.setFrom(FROM);
        if (totalItems > MAXIMUM_WATCH_IN_ONE_PAGE) {
            searchResults.setTo(MAXIMUM_WATCH_IN_ONE_PAGE);
        } else {
            searchResults.setTo(totalItems);
        }
        searchResults.setItems(extractItems(doc));
        return searchResults;
    }

    private List<SearchResultItem> extractItems(Document doc) throws IOException {
        List<SearchResultItem> items = new LinkedList<SearchResultItem>();

        Elements elements = doc.select("div.category-products > div.product-grid-container");
        for (Element e : elements) {
            SearchResultItem searchResultItem = new SearchResultItem();

            String name = e.select("a").first().attr("title");
            searchResultItem.setName(name);

            String productTitle = e.select("span.product-title").first().text();
            searchResultItem.setProductTitle(productTitle);

            String productSubtitle = e.select("span.product-subtitle").first().text();
            searchResultItem.setProductSubtitle(productSubtitle);

            Price price = new Price(new BigDecimal(e.select("span.price")
                    .first().text().replaceAll("[^\\d.-]", "")), currency);
            searchResultItem.setPrice(price);

            String imageURI = e.select("span.product-image > img").first().attr("abs:src");
            searchResultItem.setImageURI(imageURI);

            String watchURI = e.select("a").first().attr("abs:href");
            searchResultItem.setWatchURI(watchURI);

            items.add(searchResultItem);
        }
        return items;
    }
}
