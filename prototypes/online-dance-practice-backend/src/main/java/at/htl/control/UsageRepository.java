package at.htl.control;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.jboss.jandex.TypeTarget;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsageRepository implements PanacheRepositoryBase<TypeTarget.Usage, String> {

}
