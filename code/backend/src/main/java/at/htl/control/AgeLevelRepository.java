package at.htl.control;

import at.htl.entity.AgeLevel;
import at.htl.entity.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AgeLevelRepository {
    @Inject
    EntityManager em;

    public AgeLevel save(AgeLevel ageLevel){
        return em.merge(ageLevel);
    }

    public List<AgeLevel> findAll(){
        return em.createNamedQuery("AgeLevel.findAll", AgeLevel.class).getResultList();
    }

    public AgeLevel findById(long id){
        return em.find(AgeLevel.class, id);
    }

    public AgeLevel findByName(String name){
        return em.createNamedQuery("AgeLevel.findByName", AgeLevel.class)
                .setParameter("NAME", name)
                .getSingleResult();
    }

    public AgeLevel delete(AgeLevel ageLevel){
        em.remove(ageLevel);
        return ageLevel;
    }
}
