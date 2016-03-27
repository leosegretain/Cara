package contrat;

import beans.ContratTypeRemote;
import entities.contrats.TypeContrat;
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
@WebServlet(name = "ContratTypeDelServlet", urlPatterns = "/contrat/type/delete")
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"ADMIN"}))
public class ContratTypeDelServlet extends HttpServlet {

    @EJB(beanName = "ContratTypeEJB")
    private ContratTypeRemote contratTypeRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        TypeContrat typeContrat = contratTypeRemote.findById(id);
        contratTypeRemote.delete(typeContrat);

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            request.setAttribute("contratTypes", contratTypeRemote.list());
            request.getRequestDispatcher("delete.jsp").forward(request, response);
        }
    }
}
