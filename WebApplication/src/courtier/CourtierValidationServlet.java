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
@WebServlet(name = "CourtierValidationServlet", urlPatterns = {"/courtier/valider"})
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"COURTIER"}))
public class CourtierValidationServlet extends HttpServlet {

    @EJB(beanName = "UserEJB")
    private beans.UserRemote userRemote;

    @EJB(beanName = "ContratEJB")
    private beans.ContratRemote contratRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int contratId = Integer.parseInt(request.getParameter("contrat").toString());
        double montant = Double.parseDouble(request.getParameter("montant").toString());
        Contrat contrat = contratRemote.findById(contratId);

        try {
            contrat.setMontant(montant);
        } catch (Exception e) {
            e.printStackTrace();
        }
        contrat.setEnAttente(false);

        contratRemote.save(contrat);

        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
