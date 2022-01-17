package model;

import org.apache.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

public class EkgData {


    private List<Double> data = new ArrayList<>();



    public List<Double> getData() {return data;}

    public void setData(List<Double> data) {this.data = data;}

    public void addEkgData(Double data) {
        this.data.add(data);
    }
/*
    private String cpr;
    private int sessionID;
    public String getCpr() {return cpr;}
    public void setCpr(String cpr) {this.cpr = cpr;}



    public int getSessionID() {return sessionID;}
    public void setSessionID(int sessionID) {this.sessionID = sessionID;}
*/



}