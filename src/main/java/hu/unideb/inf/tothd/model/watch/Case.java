package hu.unideb.inf.tothd.model.watch;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
public class Case {

    @XmlAttribute(required = false)
    private String caseBack;

    @XmlAttribute(required = false)
    private String dimension;

    @XmlAttribute(required = false)
    private String lugDistance;

    @XmlAttribute(required = false)
    private String glass;

    @XmlAttribute(required = false)
    private String material;

    @XmlAttribute(required = false)
    private String shape;

    @XmlAttribute(required = false)
    private String waterResistance;

    public Case() {
        super();
    }

    public Case(String caseBack, String dimension, String lugDistance, String glass, String material, String shape,
                String waterResistance) {
        super();
        this.caseBack = caseBack;
        this.dimension = dimension;
        this.lugDistance = lugDistance;
        this.glass = glass;
        this.material = material;
        this.shape = shape;
        this.waterResistance = waterResistance;
    }

    public String getCaseBack() {
        return caseBack;
    }

    public void setCaseBack(String caseBack) {
        this.caseBack = caseBack;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getLugDistance() {
        return lugDistance;
    }

    public void setLugDistance(String lugDistance) {
        this.lugDistance = lugDistance;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(String waterResistance) {
        this.waterResistance = waterResistance;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}