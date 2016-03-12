package entities.contrats;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@DiscriminatorValue("VIE")
public class ContratVie extends Contrat {

    private double montantCapital;
    private int dureeCotisationMin;

    public double getMontantCapital() {
        return montantCapital;
    }

    public void setMontantCapital(double montantCapital) {
        this.montantCapital = montantCapital;
    }

    public int getDureeCotisationMin() {
        return dureeCotisationMin;
    }

    public void setDureeCotisationMin(int dureeCotisationMin) {
        this.dureeCotisationMin = dureeCotisationMin;
    }
}
