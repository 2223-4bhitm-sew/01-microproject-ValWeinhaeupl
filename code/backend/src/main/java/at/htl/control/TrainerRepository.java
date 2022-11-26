package at.htl.control;

import at.htl.entity.Trainer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TrainerRepository {
    @Inject
    EntityManager em;

    public Trainer save(Trainer trainer) {
        return em.merge(trainer);
    }

    public List<Trainer> findAll(){
        return em.createNamedQuery("Trainer.findAll", Trainer.class).getResultList();
    }

    public Trainer findById(long id){
        return em.find(Trainer.class, id);
    }

    public Trainer findByFirstAndLastName(String firstname, String lastname){
        return em.createNamedQuery("Trainer.findByFirstAndLastName", Trainer.class)
                .setParameter("FIRSTNAME", firstname)
                .setParameter("LASTNAME", lastname)
                .getSingleResult();
    }

    public Trainer delete(Trainer trainer){
        em.remove(trainer);
        return trainer;
    }
}
