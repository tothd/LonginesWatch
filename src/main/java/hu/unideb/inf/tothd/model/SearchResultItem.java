package hu.unideb.inf.tothd.model;


import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "name",
        "productTitle",
        "productSubtitle",
        "price",
        "imageURI",
        "watchURI"
}
)
public class SearchResultItem {

    @XmlAttribute(required = true)
    private String uri;

    @XmlElement(required = true)
    private String name;

    @XmlElement(required = true)
    private String productTitle;

    @XmlElement(required = true)
    private String productSubtitle;

    @XmlElement(required = true)
    private Price price;

    @XmlElement(required = true)
    private String imageURI;

    @XmlElement(required = true)
    private String watchURI;

    public SearchResultItem() {
    }

    public SearchResultItem(String uri, String name, String productTitle, String productSubtitle, Price price, String imageURI, String watchURI) {
        this.uri = uri;
        this.name = name;
        this.productTitle = productTitle;
        this.productSubtitle = productSubtitle;
        this.price = price;
        this.imageURI = imageURI;
        this.watchURI = watchURI;
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

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getWatchURI() {
        return watchURI;
    }

    public void setWatchURI(String watchURI) {
        this.watchURI = watchURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

