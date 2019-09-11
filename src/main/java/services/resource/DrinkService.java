package services.resource;

import com.google.gson.Gson;
import models.MenuItem;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/drink")
public class DrinkService {

    @Path("/verify")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyTest(){
        String result = "Your getting to know how to use REST";

        return Response.status(200).entity(result).build();
    }
}
