package hu.unideb.inf.tothd.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResults {

    @XmlAttribute(required = true)
    private int itemsTotal;

    @XmlAttribute(required = true)
    private int from;

    @XmlAttribute(required = true)
    private int to;

    @XmlElement(name = "item")
    private List<SearchResultItem> items;

    public SearchResults() {
    }

    public SearchResults(int itemsTotal, int from, int to, List<SearchResultItem> items) {
        this.itemsTotal = itemsTotal;
        this.from = from;
        this.to = to;
        this.items = items;
    }

    public int getItemsTotal() {
        return itemsTotal;
    }

    public void setItemsTotal(int itemsTotal) {
        this.itemsTotal = itemsTotal;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public List<SearchResultItem> getItems() {
        return items;
    }

    public void setItems(List<SearchResultItem> items) {
        this.items = items;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}