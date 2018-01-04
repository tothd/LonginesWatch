package hu.unideb.inf.tothd.model;


import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        propOrder = {
                "productTitle",
                "productSubtitle",
                "price",
        }
)
public class SearchResultItem {

    @XmlAttribute(required = false)
    private String uri;

    @XmlElement(required = false)
    private String productTitle;

    @XmlElement(required = true)
    private String productSubtitle;

    @XmlElement(required = true)
    private Price price;

    public SearchResultItem() {
    }

    public SearchResultItem(String uri, String productTitle, String productSubtitle, Price price) {
        this.uri = uri;
        this.productTitle = productTitle;
        this.productSubtitle = productSubtitle;
        this.price = price;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductSubtitle() {
        return productSubtitle;
    }

    public void setProductSubtitle(String productSubtitle) {
        this.productSubtitle = productSubtitle;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}

