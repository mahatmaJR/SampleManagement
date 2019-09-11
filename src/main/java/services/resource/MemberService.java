package services.resource;

import DAO.interfaces.MemberRepository;
import com.google.gson.Gson;
import models.Member;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/member")
public class MemberService {

    @EJB
    MemberRepository memberRepository;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addMember(String json){
        Member member = new Gson().fromJson(json, Member.class);
        memberRepository.newMember(member);
        return "success";
    }

    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewMemberById(@PathParam("id") int id){
        Member member = (Member) memberRepository.getMemberById(id);
        return Response.ok().entity(member).build();
    }

    @Path("/allMembers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMembers(){
        List<Member> memberList = memberRepository.getAllMembers();
        GenericEntity<List<Member>> memberWrapper = new GenericEntity<List<Member>>(memberList){};

        return Response.ok(memberWrapper).build();
    }

    @Path("/verify")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyTest(){
        String result =  "Your getting to know how to use REST";

        return Response.status(200).entity(result).build();
    }
}
