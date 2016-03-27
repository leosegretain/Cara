package entities.contrats;

import entities.user.CaraUser;

import javax.persistence.*;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE_CONTRAT")
@NamedQueries({
        @NamedQuery(name = "findContratById", query = "SELECT u FROM Contrat u where u.id = :id"),
        @NamedQuery(name = "findAllContrats", query = "select u from Contrat u")
})
public class Contrat {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "MONTANT")
    private double montant;

    @ManyToOne
    private CaraUser userAssure;

    @ManyToOne
    private TypeContrat typeContrat;

    @Column(name = "DTYPE_CONTRAT", insertable = false, updatable = false)
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

    public void setMontant(double montant) throws Exception {

        if (montant < this.getTypeContrat().getMontantMin())
            throw new Exception("Montant minimal invalide !");

        this.montant = montant;
    }

    public CaraUser getUserAssure() {
        return userAssure;
    }

    public void setUserAssure(CaraUser userAssure) {
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
