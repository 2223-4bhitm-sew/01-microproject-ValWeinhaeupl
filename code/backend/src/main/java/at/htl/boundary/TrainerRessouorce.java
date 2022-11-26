package at.htl.boundary;

import at.htl.control.TrainerRepository;
import at.htl.entity.Trainer;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/trainer")
public class TrainerRessouorce {
    @Inject
    Logger logger;

    @Inject
    TrainerRepository trainerRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trainer> findAll(){
        return trainerRepository.findAll();
    }

    @GET
    @Path("{trainerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Trainer findById(@PathParam("trainerId") long trainerId){
        logger.info(trainerId);
        return trainerRepository.findById(trainerId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Trainer findByFirstAndLastName(String firstname, String lastname){
        return trainerRepository.findByFirstAndLastName(firstname, lastname);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Trainer create(Trainer trainer){
        Trainer saved = trainerRepository.save(trainer);
        logger.info(saved.getLastName() + " wird gespeichert");
        return saved;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Trainer delete(Trainer trainer){
        trainerRepository.delete(trainer);
        return trainer;
    }
}
