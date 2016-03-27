package user;

import entities.user.CaraUser;
import entities.user.UserAdmin;
import entities.user.UserAssure;
import entities.user.UserCourtier;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Léo on 09/02/2016.
 */
@WebServlet(name = "UserAddServlet", urlPatterns = "/user/add")
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"ADMIN"}))
public class UserAddServlet extends HttpServlet {

    @EJB(beanName = "UserEJB")
    private beans.UserRemote userRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("nom").toString();
        String prenom = request.getParameter("prenom").toString();
        String email = request.getParameter("email").toString();
        String motdepasse = request.getParameter("motdepasse").toString();
        String adresse = request.getParameter("adresse").toString();
        String dtype = request.getParameter("dtype").toString();
        String courtier = request.getParameter("courtier").toString();

        CaraUser caraUser = new CaraUser();
        caraUser.setNom(nom);
        caraUser.setPrenom(prenom);
        caraUser.setEmail(email);
        caraUser.setMotDePasse(motdepasse);

        switch (dtype) {

            case "ADMINISTRATEUR":
                UserAdmin userAdmin = new UserAdmin(caraUser);

                userRemote.add(userAdmin);
                break;

            case "ASSURE":
                UserAssure userAssure = new UserAssure(caraUser);

                UserCourtier dedicatedCourtier = new UserCourtier(userRemote.findByName(courtier));
                userAssure.setAdresse(adresse);
                userAssure.setCourtier(dedicatedCourtier);

                userRemote.add(userAssure);
                break;

            case "COURTIER":
                UserCourtier userCourtier = new UserCourtier(caraUser);

                userRemote.add(userCourtier);
                break;

        }

        request.getRequestDispatcher("//welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            List<UserCourtier> courtiers = userRemote.listCourtiers();
            request.setAttribute("courtiers", courtiers);
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
    }
}
