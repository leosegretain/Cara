package entities.contrats;

import javax.persistence.*;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "findContratTypeById", query = "SELECT u FROM TypeContrat u where u.id = :id"),
        @NamedQuery(name = "findAllContratsType", query = "select u from TypeContrat u")
})
public class TypeContrat {

    @Id
    @GeneratedValue
    private int id;
    private String description;
    private double montantMin;
    @Enumerated(EnumType.STRING)
    private CategorieContrat categorieContrat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontantMin() {
        return montantMin;
    }

    public void setMontantMin(double montantMin) {
        this.montantMin = montantMin;
    }

    public CategorieContrat getCategorieContrat() {
        return categorieContrat;
    }

    public void setCategorieContrat(CategorieContrat categorieContrat) {
        this.categorieContrat = categorieContrat;
    }

    public enum CategorieContrat {
        AUTOMOBILE,
        VIE,
        HABITATION
    }
}
