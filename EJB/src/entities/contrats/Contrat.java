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
        @NamedQuery(name = "findAllContrats", query = "select u from Contrat u"),
        @NamedQuery(name = "findContratsByAssure", query = "select u from Contrat u where u.userAssure.nom = :nom and u.isDemandeArret = false and u.isEnAttente = false"),
        @NamedQuery(name = "findContratsEnAttenteByAssure", query = "select u from Contrat u where u.userAssure.nom = :nom and u.isDemandeArret = true or u.isEnAttente = true")
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

    @Column(name = "IS_DEMANDE_ARRET")
    private boolean isDemandeArret = false;

    @Column(name = "DTYPE_CONTRAT", insertable = false, updatable = false)
    private String discriminator;

    @Column(name = "IS_EN_ATTENTE")
    private boolean isEnAttente = false;

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

    public boolean isDemandeArret() {
        return isDemandeArret;
    }

    public void setDemandeArret(boolean demandeArret) {
        isDemandeArret = demandeArret;
    }

    public boolean isEnAttente() {
        return isEnAttente;
    }

    public void setEnAttente(boolean enAttente) {
        isEnAttente = enAttente;
    }

    public String getEtat() {

        if (this.isDemandeArret)
            return "En attente de résiliation";
        else if (this.isEnAttente)
            return "En attente d'ouverture";
        else
            return "Souscrit";
    }
}
