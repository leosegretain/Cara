package entities.contrats;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@DiscriminatorValue("AUTO")
public class ContratAutomobile extends Contrat {

    private String modeleAutomobile;
    private String immatriculation;
    private String nomConducteurPrincipal;

    public String getModeleAutomobile() {
        return modeleAutomobile;
    }

    public void setModeleAutomobile(String modeleAutomobile) {
        this.modeleAutomobile = modeleAutomobile;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getNomConducteurPrincipal() {
        return nomConducteurPrincipal;
    }

    public void setNomConducteurPrincipal(String nomConducteurPrincipal) {
        this.nomConducteurPrincipal = nomConducteurPrincipal;
    }
}
