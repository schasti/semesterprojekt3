package model;

import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="ekgSessionList")
@XmlSeeAlso(EkgSession.class)
@XmlAccessorType(XmlAccessType.FIELD)

public class EkgSessionList {

    public List<EkgSession> getEkgSessionList() {
        return ekgSessionList;
    }

    public void setEkgSessionList(List<EkgSession> ekgSessionList) {
        this.ekgSessionList = ekgSessionList;
    }

    @XmlElement(name="ekgSession")

    private List<EkgSession> ekgSessionList = new ArrayList<>();

    public void addEkgSession(EkgSession ekgSession) {
        ekgSessionList.add(ekgSession);
    }
}
