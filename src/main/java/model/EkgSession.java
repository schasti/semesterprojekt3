package model;

public class EkgSession {

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    String cpr;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    String session;

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String timestart) {
        this.timestart = timestart;
    }

    String timestart;
}
