package courtier;

import entities.contrats.Contrat;
import entities.contrats.TypeContrat;
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
@WebServlet(name = "CourtierClientsServlet", urlPatterns = {"/courtier/clients", "/courtier/client/contrats"})
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"COURTIER"}))
public class CourtierClientsServlet extends HttpServlet {

    @EJB(beanName = "UserEJB")
    private beans.UserRemote userRemote;

    @EJB(beanName = "ContratEJB")
    private beans.ContratRemote contratRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // /courtier/client/contrats

        String client = request.getParameter("client").toString();
        List<Contrat> contrats = contratRemote.findByAssure(client);
        List<Contrat> contratsEnAttente = contratRemote.findEnAttenteByAssure(client);

        request.setAttribute("contrats", contrats);
        request.setAttribute("contratsEnAttente", contratsEnAttente);

        request.getRequestDispatcher("contrats.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // /courtier/clients

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            List<UserAssure> clients = userRemote.listAssuresByCourtier(user.getNom());

            request.setAttribute("clients", clients);

            request.getRequestDispatcher("clients.jsp").forward(request, response);
        }
    }
}
