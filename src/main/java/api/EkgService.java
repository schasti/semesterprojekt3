package api;

import controller.EkgController;
import dataAccesLayer.apiDAO;
import org.json.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("ekgSessions")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})

public class EkgService {

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String ekgpython(String data){
        System.out.println("step1 "+data);
        EkgController.getEkgControllerObj().setS(data);
        return EkgController.getEkgControllerObj().getS();
    }
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public String ekg(){
        System.out.println("step2 "+ EkgController.getEkgControllerObj().getS());
        return EkgController.getEkgControllerObj().getS();
    }


}
