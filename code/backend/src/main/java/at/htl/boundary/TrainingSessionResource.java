package at.htl.boundary;

import at.htl.control.TrainingSessionRepository;
import at.htl.entity.TrainingSession;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("trainingsession")
public class TrainingSessionResource {
    @Inject
    Logger logger;

    @Inject
    TrainingSessionRepository trainingSessionRepository;

    @GET
    @Produces("application/json")
    public List<TrainingSession> findAll(){
        return trainingSessionRepository.findAll().list();
    }

    @GET
    @Produces("application/json")
    @Path("{id}")
    public TrainingSession findById(@PathParam("id") long id) {
        return trainingSessionRepository.findById(id);
    }

    @POST
    @Transactional
    @Consumes("application/json")
    public Response create(TrainingSession trainingSession){
        trainingSessionRepository.persist(trainingSession);
        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @Consumes("application/json")
    public Response delete(TrainingSession trainingSession){
        trainingSessionRepository.delete(trainingSession);
        return Response.ok().build();
    }

}
