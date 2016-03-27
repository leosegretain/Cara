package assure;

import entities.contrats.Contrat;
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
@WebServlet(name = "AssureContratsServlet", urlPatterns = "/assure/contrats")
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"ASSURE"}))
public class AssureContratsServlet extends HttpServlet {

    @EJB(beanName = "UserEJB")
    private beans.UserRemote userRemote;

    @EJB(beanName = "ContratEJB")
    private beans.ContratRemote contratRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            List<Contrat> contrats = contratRemote.findByAssure(user.getNom());
            request.setAttribute("contrats", contrats);
            request.getRequestDispatcher("contrats.jsp").forward(request, response);
        }
    }
}
