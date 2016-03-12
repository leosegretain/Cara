package beans;

/**
 * Created by Léo on 09/02/2016.
 */
public interface UserRemote {

    public boolean authenticate(String nom, String password);
}
