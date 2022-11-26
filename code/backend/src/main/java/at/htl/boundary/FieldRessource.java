package at.htl.boundary;

import at.htl.control.FieldRepository;
import at.htl.entity.Field;
import at.htl.entity.Player;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.awt.*;
import java.net.URI;
import java.util.List;

@Path("/field")
public class FieldRessource {
    @Inject
    Logger logger;

    @Inject
    FieldRepository fieldRepository;

    @GET
    @Path("{fieldId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Field findById(@PathParam("fieldId") long fieldId){
        logger.info(fieldId);
        return fieldRepository.findById(fieldId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Field> findAll(){
        return fieldRepository.findAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Field field, @Context UriInfo uriInfo){
        Field saved = fieldRepository.save(field);
        logger.info(saved.getLocation() + " wird gespeichert");
        URI location = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(saved.getFieldId()))
                .build();
        return Response.created(location).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(Field field){
        fieldRepository.delete(field);
        return Response.noContent().build();
    }

}
