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

    private List<Player> players = new LinkedList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> findAll(){
        return playerRepository.findAll();
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
        return playerRepository.findByFirstnameAndLastname(firstName, lastName);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Player player, @Context UriInfo uriInfo){
        Player saved = playerRepository.save(player);
        logger.info(saved.getLastname() + " wird gespeichert");
        URI location = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(saved.getPlayerId()))//nicht sicher
                .build();
        return Response.created(location).build();
    }

    @PATCH
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(String firstName) {

        logger.info(players);
        logger.info(firstName);
        Player foundPlayer = players
                .stream()
                .filter(fn -> fn.getFirstname().equals(firstName))
                .findFirst()
                .get();
        logger.info(foundPlayer.getFirstname());
        foundPlayer.setFirstname("updated");
        return Response.ok(foundPlayer).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Player player) {
        if (players.size() > 0) {
            players.remove(0);
        }
        return Response.noContent().build();
    }
}
