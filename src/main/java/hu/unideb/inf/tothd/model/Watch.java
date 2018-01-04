package hu.unideb.inf.tothd.model;

import hu.unideb.inf.tothd.model.watch.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.ArrayList;

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

    public static void main(String[] args) throws Exception {
        Watch watch = new Watch();
        watch.setUri(
                "http://shop.us.longines.com/watch-selector/men/the-longines-conquest-v-h-p-43mm-carbon-fiber-dial.html");

        watch.setProductName("THE LONGINES CONQUEST V.H.P. 43MM CARBON FIBER DIAL");

        watch.setSerialNumber("L37264666");

        watch.setWatchCase(new Case("Screw-down case back", "43 mm", "22 mm",
                "Sapphire with several layers of anti-reflective coating", "Stainless Steel", "Round",
                "50 meters (164 feet)"));

        Bracelet bracelet = new Bracelet();
        bracelet.setBuckle("Deployment buckle");
        bracelet.setMaterial("Stainless Steel");
        watch.setBracelet(bracelet);

        watch.setDescription(
                "The Conquest V.H.P. ensures the display of hours, minutes and seconds to an accuracy of ±5 sec/year. This extreme accuracy is achieved through an ultra-precise quartz combined with time display correction in the event of a disturbance.");

        watch.setDialAndHands(new DialAndHands("Carbon Fiber", "Applied indexes with Super-LumiNova®", "Silver hands"));

        ArrayList<String> functions = new ArrayList<>();
        functions.add("Hours, minutes seconds in the middle");
        functions.add("Date window");
        functions.add("Perpetual Calendar");
        watch.setFunctions(new Functions(functions));

        ArrayList<String> accessories = new ArrayList<>();
        accessories.add("Longines Timepiece User Manual");
        accessories.add("Watch Box");
        accessories.add("Warranty Card");
        watch.setAccessories(new Accessories(accessories));

        Movement movement = new Movement();
        movement.setMovement("Quartz");
        movement.setIndicator("yes");
        watch.setMovement(movement);

        watch.setPrice(new Price(new BigDecimal("1,050"), "USD"));
    }
}
