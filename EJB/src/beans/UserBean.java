package beans;

import entities.user.CaraUser;

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
}