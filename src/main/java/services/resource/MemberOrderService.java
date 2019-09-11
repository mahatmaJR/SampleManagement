package services.resource;

import com.google.gson.*;
import models.MenuItem;
import models.Member;
import models.MemberOrder;
import models.Staff;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/memberorder")
public class MemberOrderService {


    @Path("/verify")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyTest(){
        String result = "Your getting to know how to use REST";

        return Response.status(200).entity(result).build();
    }
}