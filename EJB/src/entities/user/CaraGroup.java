package entities.user;

import javax.persistence.*;
import java.util.List;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
public class CaraGroup {

    @Id
    public String nom;

    @JoinColumn(name = "NOM")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<CaraUser> users;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<CaraUser> getUsers() {
        return users;
    }

    public void setUsers(List<CaraUser> users) {
        this.users = users;
    }
}
