package controller;

import com.google.gson.Gson;
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

    public AftaleListe getImportAftaleListe(String http, String liste, String listearray) {

        AftaleListe aftaleListe = new AftaleListe();

        JSONArray p = apiDAO.getApiDAOOBJ().getJsonOBJ(http).getJSONObject(liste).getJSONArray(listearray);

        for (int i = 0; i < p.length(); i++) {
            aftaleListe.addAftaler(new Gson().fromJson(String.valueOf(p.getJSONObject(i)), Aftale.class));
        }

        return aftaleListe;
    }

    public JSONObject getImportJSON(String http) {
        return apiDAO.getApiDAOOBJ().getJsonOBJ(http);
    }
}
