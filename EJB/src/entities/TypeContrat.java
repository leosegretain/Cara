package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
public class TypeContrat {

    @Id
    private int id;

    private String description;
    private double montantMin;

    @ManyToOne
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
}
