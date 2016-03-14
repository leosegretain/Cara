package beans;

import entities.user.CaraUser;

/**
 * Created by Léo on 09/02/2016.
 */
public interface UserRemote {

    public CaraUser findByName(String name);
}
