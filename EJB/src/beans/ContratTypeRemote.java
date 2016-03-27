package beans;

import entities.contrats.TypeContrat;

import java.util.List;

/**
 * Created by Léo on 27/03/2016.
 */
public interface ContratTypeRemote {

    public TypeContrat findById(int id);

    public void add(TypeContrat typeContrat);

    public void delete(TypeContrat typeContrat);

    public List<TypeContrat> list();
}
