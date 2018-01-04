package hu.unideb.inf.tothd.model.watch;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
public class Movement {

    @XmlValue
    private String movement;

    @XmlAttribute(required = false)
    private String indicator;

    @XmlAttribute(required = false)
    private String powerReserve;

    @XmlAttribute(required = false)
    private String caliber;

    public Movement() {
        super();
    }

    public Movement(String movement, String caliber, String indicator, String powerReserve) {
        super();
        this.movement = movement;
        this.caliber = caliber;
        this.indicator = indicator;
        this.powerReserve = powerReserve;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getPowerReserve() {
        return powerReserve;
    }

    public void setPowerReserve(String powerReserve) {
        this.powerReserve = powerReserve;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}