package beans;

import entities.contrats.TypeContrat;

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
@Stateless(name = "ContratTypeEJB")
public class ContratTypeBean implements ContratTypeRemote {

    @PersistenceContext(unitName = "Assurances-ejbPU")
    EntityManager persistance;

    public TypeContrat findById(int id) {

        try {
            Query q = persistance.createNamedQuery("findContratTypeById").setParameter("id", id);
            Object object = q.getResultList().get(0);
            return (TypeContrat) object;
        } catch (Exception e) {

            return null;
        }
    }

    @RolesAllowed("ADMIN")
    public void add(TypeContrat contrat) {

        persistance.persist(contrat);
    }

    @RolesAllowed("ADMIN")
    public void delete(TypeContrat contrat) {

        TypeContrat toBeRemoved = persistance.merge(contrat);
        persistance.remove(toBeRemoved);
    }

    @RolesAllowed({"ADMIN", "ASSURE", "COURTIER"})
    public List<TypeContrat> list() {

        try {
            Query q = persistance.createNamedQuery("findAllContratsType");
            List<TypeContrat> objects = q.getResultList();
            return objects;
        } catch (Exception e) {

            return null;
        }
    }
}