package controller;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import dataAccesLayer.apiDAO;
import model.Aftale;
import model.AftaleListe;
import org.json.JSONArray;
import org.json.JSONObject;

public class EkgController {

    private EkgController() {
    }

    static private final EkgController EkgControllerObj = new EkgController();

    static public EkgController  getEkgControllerObj() {
        return EkgControllerObj;
    }

    public String getString(String s){
     return s;
    }
}
