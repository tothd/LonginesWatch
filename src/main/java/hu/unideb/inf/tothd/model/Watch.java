package hu.unideb.inf.tothd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@javax.xml.bind.annotation.XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlType(propOrder = {"productName", "serialNumber", "accessories", "description",
        "bracelet", "functions", "watchCase", "dialAndHands", "movement", "price"})
public class Watch {

    @XmlAttribute(required = true)
    private String uri;

    @XmlElement(required = true)
    private String productName;

    @XmlElement(required = true)
    private String serialNumber;

    @XmlElement(name = "accessories", required = false)
    private Accessories accessories;

    @XmlElement(required = false)
    private Case watchCase;

    @XmlElement(required = false)
    private String description;

    @XmlElement(required = false)
    private Bracelet bracelet;

    @XmlElement(name = "functions", required = true)
    private Functions functions;

    @XmlElement(required = false)
    private DialAndHands dialAndHands;

    @XmlElement(required = false)
    private Movement movement;

    @XmlElement(required = true)
    private Price price;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Case getWatchCase() {
        return watchCase;
    }

    public void setWatchCase(Case watchCase) {
        this.watchCase = watchCase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bracelet getBracelet() {
        return bracelet;
    }

    public void setBracelet(Bracelet bracelet) {
        this.bracelet = bracelet;
    }

    public DialAndHands getDialAndHands() {
        return dialAndHands;
    }

    public void setDialAndHands(DialAndHands dialAndHands) {
        this.dialAndHands = dialAndHands;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Accessories getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessories accessories) {
        this.accessories = accessories;
    }

    public Functions getFunctions() {
        return functions;
    }

    public void setFunctions(Functions functions) {
        this.functions = functions;
    }
}
