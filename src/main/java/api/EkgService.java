package api;

import com.google.gson.Gson;
import controller.EkgController;
import model.EkgData;
import org.apache.http.HttpHeaders;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("ekgSessions")

public class EkgService {


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public EkgData ekgpython(EkgData data){

        System.out.println("hej hej    "+data.getData()+"      farvel    farvel ");

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
