package at.htl.control;

import at.htl.entity.AccessToken;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;

@ApplicationScoped
@Transactional
public class AccessTokenRepository implements PanacheRepository<AccessToken> {

    public AccessToken save(AccessToken accessToken) {
        return getEntityManager().merge(accessToken);
    }

    public boolean validate(AccessToken accessToken) {

        if (accessToken == null) {
            return false;
        }
        if (accessToken.daysValid == null && accessToken.expireDate == null
                && accessToken.activationDate != null) {
            return true;
        } else if (accessToken.activationDate != null) {
            if (accessToken.daysValid != null
                    && accessToken.activationDate.plusDays(accessToken.daysValid).isAfter(LocalDate.now())) {
                return true;
            } else if (accessToken.expireDate != null && LocalDate.now().isBefore(accessToken.expireDate)) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public AccessToken activateToken(AccessToken accessToken) {
        if (accessToken.activationDate != null) {
            return accessToken;
        }
        accessToken.activationDate = LocalDate.now();
        return getEntityManager().merge(accessToken);
    }

}
