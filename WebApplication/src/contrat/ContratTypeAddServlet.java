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
@WebServlet(name = "ContratTypeAddServlet", urlPatterns = "/contrat/type/add")
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"ADMIN"}))
public class ContratTypeAddServlet extends HttpServlet {

    @EJB(beanName = "ContratTypeEJB")
    private ContratTypeRemote contratTypeRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String categorie = request.getParameter("categorie").toString();
        String description = request.getParameter("description").toString();
        double montantMin = Double.parseDouble(request.getParameter("montantMin").toString());

        TypeContrat typeContrat = new TypeContrat();
        typeContrat.setDescription(description);
        typeContrat.setMontantMin(montantMin);

        switch (categorie) {

            case "AUTOMOBILE":
                typeContrat.setCategorieContrat(TypeContrat.CategorieContrat.AUTOMOBILE);
                break;

            case "VIE":
                typeContrat.setCategorieContrat(TypeContrat.CategorieContrat.VIE);
                break;

            case "HABITATION":
                typeContrat.setCategorieContrat(TypeContrat.CategorieContrat.HABITATION);
                break;
        }

        contratTypeRemote.add(typeContrat);
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
    }
}
