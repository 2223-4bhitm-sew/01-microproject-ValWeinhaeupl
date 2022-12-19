package at.htl.control;

import at.htl.entity.AgeLevel;
import at.htl.entity.Player;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AgeLevelRepository implements PanacheRepository<AgeLevel> {
}
