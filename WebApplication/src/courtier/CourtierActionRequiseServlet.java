package courtier;

import entities.contrats.Contrat;
import entities.user.CaraUser;
import entities.user.UserAssure;

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
@WebServlet(name = "CourtierActionRequiseServlet", urlPatterns = "/courtier/actions")
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"COURTIER"}))
public class CourtierActionRequiseServlet extends HttpServlet {

    @EJB(beanName = "ContratEJB")
    private beans.ContratRemote contratRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            List<Contrat> contratsEnAttente = contratRemote.listActionRequise(user.getNom());

            request.setAttribute("contratsEnAttente", contratsEnAttente);

            request.getRequestDispatcher("contratsEnAttente.jsp").forward(request, response);
        }
    }
}
