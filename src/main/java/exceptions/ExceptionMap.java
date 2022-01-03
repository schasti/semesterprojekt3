package exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMap implements ExceptionMapper<OurException>{
    @Override
    public Response toResponse(OurException ex) {
        return Response.status(400).entity(ex.getMessage()).type("text/plain").build();
    }
}

