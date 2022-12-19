package at.htl.control;

import at.htl.entity.Field;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FieldRepository implements PanacheRepository<Field> {

}
