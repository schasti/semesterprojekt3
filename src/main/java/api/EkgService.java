package api;

import org.json.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import controller.EkgController;

@Path("ekgSessions")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})

public class EkgService {

    @Path("postEkg")
    @POST
    @Consumes({MediaType.TEXT_PLAIN})
    public String ekgpython(String data){
        return EkgController.getEkgControllerObj().getString(data);
    }

}
