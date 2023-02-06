package at.htl.boundary;

import at.htl.control.AgeLevelRepository;
import at.htl.entity.AgeLevel;
import at.htl.entity.Player;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/agelevel")
public class AgeLevelResource {
    @Inject
    Logger logger;

    @Inject
    AgeLevelRepository ageLevelRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AgeLevel> findAll(){
        return ageLevelRepository.findAll().list();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AgeLevel findById(@PathParam("id") long ageLevelId){
        logger.info(ageLevelId);
        return ageLevelRepository.findById(ageLevelId);
    }

    @GET
    @Path("byName")
    @Produces(MediaType.APPLICATION_JSON)
    public AgeLevel findByName(@QueryParam("ageLevelName") String name){
        logger.info(name);
        return ageLevelRepository.find("ageLevelName", name).firstResult();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(AgeLevel ageLevel){
        ageLevelRepository.persist(ageLevel);
        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") long id){
        ageLevelRepository.deleteById(id);
        return Response.ok().build();
    }
}
