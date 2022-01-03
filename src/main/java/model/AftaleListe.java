package model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="aftaleListe")
@XmlSeeAlso(Aftale.class)
@XmlAccessorType(XmlAccessType.FIELD)
//@jakarta.xml.bind.annotation.XmlRootElement(name="aftaleListe")
//@jakarta.xml.bind.annotation.XmlSeeAlso(Aftale.class)
public class AftaleListe {

    @XmlElement(name="aftale")
    //@jakarta.xml.bind.annotation.XmlElement(name="aftale")
    List<Aftale> aftaleListe = new ArrayList<>();

    public List<Aftale> getAftaler() {
        return aftaleListe;
    }

    public void addAftaler(Aftale aftale) {
        aftaleListe.add(aftale);
    }
}
