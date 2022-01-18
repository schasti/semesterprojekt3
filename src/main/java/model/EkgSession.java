package model;

import java.util.List;

public class EkgSession {



    private String cpr;
    private String sessionID;
    private String timeStart;
    private String markers;
    private String comment;

    @Override
    public String toString() {
        return "ekgSession{" +
                "sessionID=" + sessionID +
                ", cpr='" + cpr + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", markers=" + markers +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getMarkers() {return markers;}
    public void setMarkers(String markers) {this.markers = markers;}

    public String getComment() {return comment;}
    public void setComment(String comment) {this.comment = comment;}

    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getCpr() {
        return cpr;
    }
    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getTimestart() {
        return timeStart;
    }
    public void setTimestart(String timestart) {
        this.timeStart = timestart;
    }


}
