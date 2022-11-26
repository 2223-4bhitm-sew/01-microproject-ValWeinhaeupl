package at.htl.control;

import at.htl.entity.Field;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FieldRepository {
    @Inject
    EntityManager em;

    public Field save(Field field) {
        return em.merge(field);
    }

    public List<Field> findAll(){
        return em.createNamedQuery("Field.findAll", Field.class).getResultList();
    }

    public Field findById(long id){
        return em.find(Field.class, id);
    }

    public Field findByLocation(String location){
        return em.createNamedQuery("Field.findByLocation", Field.class)
                .setParameter("LOCATION", location)
                .getSingleResult();
    }

    public Field delete(Field field){
        em.remove(field);
        return field;
    }
}
