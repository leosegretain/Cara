package beans;

import entities.user.CaraUser;
import entities.user.UserAssure;
import entities.user.UserCourtier;

import java.util.List;

/**
 * Created by Léo on 09/02/2016.
 */
public interface UserRemote {

    public CaraUser findByName(String name);

    public void add(CaraUser caraUser);

    public void delete(CaraUser caraUser);

    public List<CaraUser> list();

    public List<UserAssure> listAssures();

    public List<UserCourtier> listCourtiers();
}
