import entities.contrats.Contrat;
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
@WebServlet(name = "ContratDelServlet", urlPatterns = "/contratDel")
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"COURTIER"}))
public class ContratDelServlet extends HttpServlet {

    @EJB(beanName = "ContratEJB")
    private beans.ContratRemote contratRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int contratId = Integer.parseInt(request.getParameter("contratId"));
        Contrat contrat = contratRemote.findById(contratId);
        contratRemote.delete(contrat);

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            request.setAttribute("contrats", contratRemote.list());
            request.getRequestDispatcher("contratDel.jsp").forward(request, response);
        }
    }
}
