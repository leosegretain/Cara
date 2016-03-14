package entities.user;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by Léo on 09/02/2016.
 */
@WebServlet(name = "UserAddServlet")
public class UserAddServlet extends HttpServlet {

    @EJB(beanName = "UserEJB")
    private beans.UserRemote userRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getAttribute("nom").toString();
        String prenom = request.getAttribute("prenom").toString();
        String email = request.getAttribute("email").toString();
        String motdepasse = request.getAttribute("motdepasse").toString();
        String adresse = request.getAttribute("adresse").toString();
        String dtype = request.getAttribute("dtype").toString();

        userRemote.add
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            request.getRequestDispatcher("userAdd.jsp").forward(request, response);
        }
    }
}
