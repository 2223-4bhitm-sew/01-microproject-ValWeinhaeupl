package at.htl.control;

import at.htl.entity.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class PlayerRepository {
    @Inject
    EntityManager em;

    public Player save(Player player) {
        return em.merge(player);
    }

    public List<Player> findAll(){
        TypedQuery<Player> query = em.createNamedQuery("Player.findAll", Player.class);
        return query.getResultList();
    }

    public Player findById(long id){
        return em.find(Player.class, id);
    }

    public List<Player> findByFirstnameAndLastname(
            String firstName,
            String lastName
    ) {
        TypedQuery<Player> query = em
                .createNamedQuery("Player.findByFirstNameAndLastName", Player.class)
                .setParameter("FIRST", firstName)
                .setParameter("LAST", lastName);
        return query.getResultList();
    }
}
