package entities.contrats;

import entities.TypeContrat;
import entities.user.UserAssure;

import javax.persistence.*;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE_CONTRAT")
public class Contrat {

    @Id
    @GeneratedValue
    private int id;

    private double montant;

    @ManyToOne
    private UserAssure userAssure;

    @ManyToOne
    private TypeContrat typeContrat;

    @Column(name="DTYPE_CONTRAT",insertable=false, updatable=false)
    private String discriminator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public UserAssure getUserAssure() {
        return userAssure;
    }

    public void setUserAssure(UserAssure userAssure) {
        this.userAssure = userAssure;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }
}
