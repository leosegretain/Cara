package beans;

import entities.user.CaraUser;
import entities.user.UserAssure;
import entities.user.UserCourtier;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Léo on 09/02/2016.
 */
@PermitAll
@Stateless(name = "UserEJB")
public class UserBean implements UserRemote {

    @PersistenceContext(unitName = "Assurances-ejbPU")
    EntityManager persistance;

    public CaraUser findByName(String name) {

        try {
            Query q = persistance.createNamedQuery("findUserByName").setParameter("nom", name);
            Object userBdd = q.getResultList().get(0);
            return (CaraUser) userBdd;
        } catch (Exception e) {

            return null;
        }
    }

    @RolesAllowed("ADMIN")
    public void add(CaraUser caraUser) {

        persistance.persist(caraUser);
    }

    @RolesAllowed("ADMIN")
    public void delete(CaraUser caraUser) {

        CaraUser toBeRemoved = persistance.merge(caraUser);
        persistance.remove(toBeRemoved);
    }

    @RolesAllowed("ADMIN")
    public List<CaraUser> list() {

        try {
            Query q = persistance.createNamedQuery("findAllUsers");
            List<CaraUser> users = q.getResultList();
            return users;
        } catch (Exception e) {

            return null;
        }
    }

    @RolesAllowed("ADMIN")
    public List<UserCourtier> listCourtiers() {

        try {
            Query q = persistance.createNamedQuery("findAllCourtiers");
            List<UserCourtier> users = q.getResultList();
            return users;
        } catch (Exception e) {

            return null;
        }
    }

    @RolesAllowed("COURTIER")
    public List<UserAssure> listAssures() {

        try {
            Query q = persistance.createNamedQuery("findAllAssures");
            List<UserAssure> users = q.getResultList();
            return users;
        } catch (Exception e) {

            return null;
        }
    }
}