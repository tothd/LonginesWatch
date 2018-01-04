package hu.unideb.inf.tothd.model.watch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
public class Functions {

    @XmlElement(name = "function", required = false)
    private List<String> functions = new ArrayList<>();

    public List<String> getFunctions() {
        return functions;
    }

    public void setFunctions(List<String> functions) {
        this.functions = functions;
    }

    public Functions() {
        super();
    }

    public Functions(List<String> functions) {
        super();
        this.functions = functions;
    }
}
