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
public class AgeLevelRessouorce {
    @Inject
    Logger logger;

    @Inject
    AgeLevelRepository ageLevelRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AgeLevel> findAll(){
        return ageLevelRepository.findAll();
    }

    @GET
    @Path("{ageLevelId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AgeLevel findById(@PathParam("ageLevelId") long ageLevelId){
        logger.info(ageLevelId);
        return ageLevelRepository.findById(ageLevelId);
    }

    @GET
    @Path("{ageLevelName}")
    @Produces(MediaType.APPLICATION_JSON)
    public AgeLevel findByName(@PathParam("ageLevelName") String name){
        logger.info(name);
        return ageLevelRepository.findByName(name);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(AgeLevel ageLevel){
        AgeLevel saved = ageLevelRepository.save(ageLevel);
        logger.info(saved.getAgeLevelName() + " wird gespeichert");
        return Response.ok(saved).build();
    }

    @DELETE
    @Transactional
    public Response delete(AgeLevel ageLevel){
        ageLevelRepository.delete(ageLevel);
        return Response.ok().build();
    }
}
