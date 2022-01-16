package api;

import controller.EkgController;
import model.EkgData;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Path("ekgSessions")

public class EkgService {


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public EkgData ekgpython(EkgData data, @Context HttpHeaders httpHeaders){

        EkgController.getEkgControllerObj().insertPythonData(
                EkgController.getEkgControllerObj().insertHttpHeaders(
                        httpHeaders.getRequestHeader("Identifier").get(0),
                        httpHeaders.getRequestHeader("session").get(0),
                        httpHeaders.getRequestHeader("Timestart").get(0)
                )
        );


        return data;
    }



   /* public EkgData ekgpython(@QueryParam("identifier") String cpr,@QueryParam("session") String session, String data){


        ekgdata.setCpr(cpr);
        ekgdata.setSession(Integer.parseInt(session));

        ekgdata.setDatanotlist(data);
        return ekgdata ;
    }*/


    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public void ekg(){

    }


}
