package api;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("ekgSessions")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML})

public class EkgService {

    @GET
    public String ekgpython(@QueryParam("cpr") int cpr){
        JSONObject jsonObject1;

    }

}
