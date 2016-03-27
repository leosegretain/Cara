package entities.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@DiscriminatorValue("COURTIER")

public class UserCourtier extends CaraUser {

    @OneToMany
    private Collection<UserAssure> assures;

    public UserCourtier() {
    }

    public UserCourtier(CaraUser caraUser) {

        this.setNom(caraUser.getNom());
        this.setPrenom(caraUser.getPrenom());
        this.setEmail(caraUser.getEmail());
        this.setMotDePasse(caraUser.getMotDePasse());
    }

    public UserCourtier(String email, String motDePasse) {
        super(email, motDePasse);
    }

    public Collection<UserAssure> getAssures() {
        return assures;
    }

    public void setAssures(Collection<UserAssure> assures) {
        this.assures = assures;
    }
}
