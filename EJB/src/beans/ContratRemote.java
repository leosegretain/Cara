package beans;

import entities.contrats.Contrat;

import java.util.List;

/**
 * Created by Léo on 27/03/2016.
 */
public interface ContratRemote {

    public Contrat findById(int id);

    public List<Contrat> findByAssure(String nom);

    public List<Contrat> findEnAttenteByAssure(String nom);

    public void save(Contrat contrat);
    
    public void add(Contrat contrat);

    public void delete(Contrat contrat);

    public List<Contrat> list();

    public List<Contrat> listActionRequise(String nom);
}
