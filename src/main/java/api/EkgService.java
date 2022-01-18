package api;

import controller.EkgController;
import exceptions.OurException;
import model.EkgData;
import model.EkgSession;
import model.EkgSessionList;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;

import java.sql.SQLException;

@Path("ekgSession")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML})

public class EkgService {


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public EkgData ekgpython(EkgData data, @Context HttpHeaders httpHeaders) {

        EkgController.getEkgControllerObj().insertPythonData(
                EkgController.getEkgControllerObj().insertHttpHeaders(
                        httpHeaders.getRequestHeader("Identifier").get(0),
                        httpHeaders.getRequestHeader("session").get(0),
                        httpHeaders.getRequestHeader("Timestart").get(0)
                ), data
        );

        return data;
    }


    @GET
    public EkgSessionList getSession(@QueryParam("cpr") String cpr) throws SQLException, OurException {
        return EkgController.getEkgControllerObj().cprSearchEkg(cpr);
    }

    @Path("measurements")
    @GET
    public EkgData getEkgData(@QueryParam("sessionID") String sessionID){
        return EkgController.getEkgControllerObj().sessionSearchData(sessionID);
    }
}
