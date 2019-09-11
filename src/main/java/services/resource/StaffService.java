package services.resource;

import services.WebApplication;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/staff")
public class StaffService extends WebApplication {

    @Path("/verify")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyTest(){
        String result = "Your getting to know how to use REST";

        System.out.println("The Rest is Here");

        return Response.status(200).entity(result).build();
    }

}
