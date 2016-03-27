package beans;

import entities.contrats.Contrat;

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
@Stateless(name = "ContratEJB")
public class ContratBean implements ContratRemote {

    @PersistenceContext(unitName = "Assurances-ejbPU")
    EntityManager persistance;

    @RolesAllowed("COURTIER")
    public Contrat findById(int id) {

        try {
            Query q = persistance.createNamedQuery("findContratById").setParameter("id", id);
            Object object = q.getResultList().get(0);
            return (Contrat) object;
        } catch (Exception e) {

            return null;
        }
    }

    @RolesAllowed("COURTIER")
    public void add(Contrat contrat) {

        persistance.persist(contrat);
    }

    @RolesAllowed("COURTIER")
    public void delete(Contrat contrat) {

        Contrat toBeRemoved = persistance.merge(contrat);
        persistance.remove(toBeRemoved);
    }

    @RolesAllowed("COURTIER")
    public List<Contrat> list() {

        try {
            Query q = persistance.createNamedQuery("findAllContrats");
            List<Contrat> objects = q.getResultList();
            return objects;
        } catch (Exception e) {

            return null;
        }
    }
}