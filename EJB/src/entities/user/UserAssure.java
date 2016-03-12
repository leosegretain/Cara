package entities.user;

import entities.contrats.Contrat;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@DiscriminatorValue("ASSURE")
public class UserAssure extends CaraUser {

    @OneToMany
    private Collection<Contrat> contrats;

    private String adresse;

    public UserAssure() {
    }

    public UserAssure(String email, String motDePasse) {
        super(email, motDePasse);
    }

    public Collection<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(Collection<Contrat> contrats) {
        this.contrats = contrats;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
