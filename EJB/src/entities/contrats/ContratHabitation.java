package entities.contrats;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@DiscriminatorValue("HAB")
public class ContratHabitation extends Contrat {

    private double montantAssureMax;
    private String adresse;

    public double getMontantAssureMax() {
        return montantAssureMax;
    }

    public void setMontantAssureMax(double montantAssureMax) {
        this.montantAssureMax = montantAssureMax;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
