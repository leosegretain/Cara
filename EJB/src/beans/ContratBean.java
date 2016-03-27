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

    @RolesAllowed({"COURTIER", "ASSURE"})
    public Contrat findById(int id) {

        try {
            Query q = persistance.createNamedQuery("findContratById").setParameter("id", id);
            Object object = q.getResultList().get(0);
            return (Contrat) object;
        } catch (Exception e) {

            return null;
        }
    }

    @RolesAllowed({"COURTIER", "ASSURE"})
    public void save(Contrat contrat) {

        Contrat toBePersist = persistance.merge(contrat);
        persistance.persist(toBePersist);
    }

    @RolesAllowed({"ASSURE", "COURTIER"})
    public List<Contrat> findByAssure(String nom) {

        try {
            Query q = persistance.createNamedQuery("findContratsByAssure")
                    .setParameter("nom", nom);
            List<Contrat> contrats = q.getResultList();
            return contrats;
        } catch (Exception e) {

            return null;
        }
    }

    @RolesAllowed({"ASSURE", "COURTIER"})
    public List<Contrat> findEnAttenteByAssure(String nom) {

        try {
            Query q = persistance.createNamedQuery("findContratsEnAttenteByAssure")
                    .setParameter("nom", nom);
            List<Contrat> contrats = q.getResultList();
            return contrats;
        } catch (Exception e) {

            return null;
        }
    }

    @RolesAllowed({"COURTIER", "ASSURE"})
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