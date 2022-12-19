package at.htl.boundary;

import at.htl.control.TrainerRepository;
import at.htl.entity.Trainer;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/trainer")
public class TrainerResource {
    @Inject
    Logger logger;

    @Inject
    TrainerRepository trainerRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trainer> findAll(){
        return trainerRepository.findAll().list();
    }

    @GET
    @Path("{trainerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Trainer findById(@PathParam("trainerId") long trainerId){
        logger.info(trainerId);
        return trainerRepository.findById(trainerId);
    }

    @GET
    @Path("(/firstandlast")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trainer> findByFirstAndLastName(@QueryParam("first") String firstName,
                                          @QueryParam("last") String lastName){
        return trainerRepository.find("firstName = ?1 and lastName = ?2", firstName, lastName).list();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Trainer trainer){
        trainerRepository.persist(trainer);
        return Response.ok().build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Trainer delete(Trainer trainer){
        trainerRepository.delete(trainer);
        return trainer;
    }
}
