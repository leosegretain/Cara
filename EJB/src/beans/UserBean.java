package beans;

import entities.user.CaraUser;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Léo on 09/02/2016.
 */
@Stateless(name = "UserEJB")
public class UserBean implements UserRemote {

    @PersistenceContext(unitName = "Assurances-ejbPU")
    EntityManager persistance;

    public CaraUser findByName(String name) {

        try {
            Query q = persistance.createNamedQuery("findUserByName").setParameter("nom", name);
            Object userBdd = q.getResultList().get(0);
            int i = 0;
            return (CaraUser) userBdd;
        } catch (Exception e) {

            return null;
        }
    }

    public CaraUser add(CaraUser caraUser) {

        try {
            Query q = persistance.createNamedQuery("add").setParameter("nom", name);
            Object userBdd = q.getResultList().get(0);
            int i = 0;
            return (CaraUser) userBdd;
        } catch (Exception e) {

            return null;
        }
    }
}