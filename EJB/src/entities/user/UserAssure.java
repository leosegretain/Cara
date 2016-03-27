package entities.user;

import entities.contrats.Contrat;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @ManyToOne
    private UserCourtier courtier;

    public UserAssure() {
    }

    public UserAssure(CaraUser caraUser) {

        this.setNom(caraUser.getNom());
        this.setPrenom(caraUser.getPrenom());
        this.setEmail(caraUser.getEmail());
        this.setMotDePasse(caraUser.getMotDePasse());
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

    public UserCourtier getCourtier() {
        return courtier;
    }

    public void setCourtier(UserCourtier courtier) {
        this.courtier = courtier;
    }
}
