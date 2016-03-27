import entities.user.CaraUser;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Léo on 09/02/2016.
 */
@WebServlet(name = "UserDelServlet")
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"ADMIN"}))
public class UserDelServlet extends HttpServlet {

    @EJB(beanName = "UserEJB")
    private beans.UserRemote userRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("nom");
        CaraUser caraUser = userRemote.findByName(nom);
        userRemote.delete(caraUser);

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            request.setAttribute("users", userRemote.list());
            request.getRequestDispatcher("userDel.jsp").forward(request, response);
        }
    }
}
