package hu.unideb.inf.tothd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
public class Accessories {

    @XmlElement(name = "accessory", required = false)
    private ArrayList<String> accessories = new ArrayList<>();

    public ArrayList<String> getAccessories() {
        return accessories;
    }

    public void setAccessories(ArrayList<String> accessories) {
        this.accessories = accessories;
    }

    public Accessories() {
        super();
    }

    public Accessories(ArrayList<String> accessories) {
        super();
        this.accessories = accessories;
    }
}