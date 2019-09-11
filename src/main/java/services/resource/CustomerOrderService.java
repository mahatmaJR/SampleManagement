package services.resource;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/customerOrder")
public class CustomerOrderService {


    @Path("/verify")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyRestService(String json){
        String result = "Am going to make this work by learning consistently";
        return Response.status(200).entity(result).build();
    }
}

