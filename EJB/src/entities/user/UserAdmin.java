package entities.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@DiscriminatorValue("ADMIN")
public class UserAdmin extends CaraUser {

    public UserAdmin() {
    }

    public UserAdmin(CaraUser caraUser) {

        this.setNom(caraUser.getNom());
        this.setPrenom(caraUser.getPrenom());
        this.setEmail(caraUser.getEmail());
        this.setMotDePasse(caraUser.getMotDePasse());
    }

    public UserAdmin(String email, String motDePasse) {
        super(email, motDePasse);
    }
}
