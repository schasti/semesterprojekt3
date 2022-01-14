package model;

import org.apache.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

public class EkgData {


    private List<Float> data;



    public List<Float> getData() {return data;}
    public void setData(List<Float> data) {this.data = data;}



    public void findHeaders(HttpHeaders httpHeaders){
        String cpr = String.valueOf(httpHeaders);
        System.out.println(cpr);
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