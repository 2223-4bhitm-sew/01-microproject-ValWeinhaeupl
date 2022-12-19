package at.htl.control;

import at.htl.entity.TrainingSession;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TrainingSessionRepository implements PanacheRepository<TrainingSession> {

}
