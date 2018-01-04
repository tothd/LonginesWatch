package hu.unideb.inf.tothd.model.watch;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
public class DialAndHands {

    @XmlAttribute(required = false)
    private String color;

    @XmlAttribute(required = false)
    private String hourMarkers;

    @XmlAttribute(required = false)
    private String hands;

    public DialAndHands() {
        super();
    }

    public DialAndHands(String color, String hourMarkers, String hands) {
        super();
        this.color = color;
        this.hourMarkers = hourMarkers;
        this.hands = hands;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHourMarkers() {
        return hourMarkers;
    }

    public void setHourMarkers(String hourMarkers) {
        this.hourMarkers = hourMarkers;
    }

    public String getHands() {
        return hands;
    }

    public void setHands(String hands) {
        this.hands = hands;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
