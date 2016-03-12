package beans;

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

    public boolean authenticate(String nom, String password) {

        try {
            Query q = persistance.createNamedQuery("findUser");//.setParameter("nom", nom);
            Object userBdd = q.getResultList().get(0);
            int i = 0;
            return false;//userBdd.getMotDePasse().equals(password);
        } catch (Exception e) {

            return false;
        }
    }
}