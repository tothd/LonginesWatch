package hu.unideb.inf.tothd.model.watch;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
public class Bracelet {

    @XmlAttribute(required = false)
    private String buckle;

    @XmlAttribute(required = false)
    private String color;

    @XmlAttribute(required = false)
    private String material;

    public Bracelet() {
        super();
    }

    public Bracelet(String buckle, String color, String material) {
        super();
        this.buckle = buckle;
        this.color = color;
        this.material = material;
    }

    public String getBuckle() {
        return buckle;
    }

    public void setBuckle(String buckle) {
        this.buckle = buckle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}