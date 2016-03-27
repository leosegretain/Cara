package entities.user;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE_USER")
@NamedQueries({
        @NamedQuery(name = "findUserByName", query = "SELECT u FROM CaraUser u where u.nom = :nom"),
        @NamedQuery(name = "findAllUsers", query = "select u from CaraUser u"),
        @NamedQuery(name = "findAllCourtiers", query = "select u from UserCourtier u"),
        @NamedQuery(name = "findAllAssures", query = "select u from UserAssure u")
})
public class CaraUser {

    @Id
    @Column(length=128)
    private String nom;

    private String prenom;

    private String motDePasse;

    private String email;

    @Column(name="DTYPE_USER",insertable=false, updatable=false)
    private String discriminator;

    public CaraUser() {
    }

    public CaraUser(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = DigestUtils.md5(motDePasse).toString();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

}
