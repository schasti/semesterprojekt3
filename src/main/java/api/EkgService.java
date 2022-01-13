package api;

import controller.EkgController;
import model.EkgData;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("ekgSessions")

public class EkgService {


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public EkgData ekgpython(EkgData data){
       // EkgData ekgData = new EkgData();
      // EkgController.getEkgControllerObj().setS(data);
        return data;
    }
   /* public EkgData ekgpython(@QueryParam("identifier") String cpr,@QueryParam("session") String session, String data){
        EkgData ekgdata = new EkgData();

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
