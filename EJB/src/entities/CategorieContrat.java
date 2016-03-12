package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by leo on 31/01/2016.
 */
@Entity
public class CategorieContrat  {

    @Id
    private int id;

    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {

        if(nom.equals("Habitation") || nom.equals("Vie") || nom.equals("Automobile"))
            this.nom = nom;
        else
            throw new Exception("Nom de categorie inconnue");
    }
}
