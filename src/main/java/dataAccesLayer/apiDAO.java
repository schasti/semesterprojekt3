package dataAccesLayer;


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.XML;

public class apiDAO {
    private apiDAO() {
    }

    static private final apiDAO apiDAOOBJ = new apiDAO();

    static public apiDAO getApiDAOOBJ() {
        return apiDAOOBJ;
    }

    public JSONObject getJsonOBJ(String http) {
        JSONObject s = (XML.toJSONObject(getString(http)));
        return s;
    }

    public String getString(String http) {
        String s = null;
        try {
            s = Unirest.get(http).basicAuth("Authorization","hemmeliglogin").asString().getBody();

            return s;
        } catch (UnirestException e) {
            e.printStackTrace();

            return null;
        }
    }
}
