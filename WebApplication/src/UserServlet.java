import entities.user.CaraUser;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by Léo on 09/02/2016.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {

    @EJB(beanName = "UserEJB")
    private beans.UserRemote userRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Principal user = request.getUserPrincipal();

        if (user != null) {

            CaraUser caraUser = userRemote.findByName(user.getName());
            request.setAttribute("user", caraUser);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
    }
}
