package api;

import controller.JWTHandler;
import model.User;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        /* Kontrol af private key på aftaler endpoint */
        //Hvis det ikke er login siden udføre vi kontrol af token
        if (!"login".equals(containerRequestContext.getUriInfo().getPath()) && !"ekgSessions".equals(containerRequestContext.getUriInfo().getPath())) {
            if (containerRequestContext.getHeaderString("Authorization") == null) {
                throw new WebApplicationException("Ingen Token", 401);
            } else {
                try {
                    User user = JWTHandler.validate(containerRequestContext.getHeaderString("Authorization"));
                } catch (Exception e) {
                    throw new WebApplicationException("Invalid Token", 401);
                }

            }
        }
        if ("ekgSessions".equals(containerRequestContext.getUriInfo().getPath()) ){
            String auth = containerRequestContext.getHeaderString("Authorization");
            if (auth == null || !auth.equals("Bearer hemmeliglogin")){
                throw new WebApplicationException(auth + "psst hvad er kodeordet?", 401);
            }
        }


    }

}
