package at.htl.boundary;

import at.htl.control.PlayerRepository;
import at.htl.entity.Player;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import org.jboss.logging.Logger;


@Path("/player")
public class PlayerResource {
    @Inject
    Logger logger;

    @Inject
    PlayerRepository playerRepository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> findAll(){
        return playerRepository.findAll().list();
    };

    @GET
    @Path("{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player findById(@PathParam("playerId") long playerId){
        logger.info(playerId);
        return playerRepository.findById(playerId);
    }

    @GET
    @Path("firstlast")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> findById(
            @QueryParam("first") String firstName,
            @QueryParam("last") String lastName
    ){
        logger.info(lastName + " " + firstName);
        return playerRepository.find("firstName = ?1 and lastName = ?2", firstName, lastName).list();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Player player, @Context UriInfo uriInfo){
        playerRepository.persist(player);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(player.getPlayerId())).build()).build();
    }

    //unsicher
    @PUT
    @Transactional
    @Path("{playerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("playerId") Long id,Player player, @Context UriInfo uriInfo){
        Player player1 = playerRepository.findById(id);
        player1.setFirstname(player.getFirstname());
        playerRepository.persist(player1);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(player.getPlayerId())).build()).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Player player) {
        playerRepository.delete(player);
        return Response.noContent().build();
    }
}
