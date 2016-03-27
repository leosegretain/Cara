package assure;

import entities.contrats.*;
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
import java.util.List;

/**
 * Created by Léo on 09/02/2016.
 */
@WebServlet(name = "AssureDemandeServlet", urlPatterns = "/assure/demande")
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"ASSURE"}))
public class AssureDemandeServlet extends HttpServlet {

    @EJB(beanName = "ContratEJB")
    private beans.ContratRemote contratRemote;

    @EJB(beanName = "ContratTypeEJB")
    private beans.ContratTypeRemote contratTypeRemote;

    @EJB(beanName = "UserEJB")
    private beans.UserRemote userRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int typeContratId = Integer.parseInt(request.getParameter("typeContrat").toString());

        Contrat contrat = new Contrat();

        TypeContrat typeContrat = contratTypeRemote.findById(typeContratId);
        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        contrat.setTypeContrat(typeContrat);
        contrat.setUserAssure(user);
        contrat.setEnAttente(true);

        switch (typeContrat.getCategorieContrat().name()) {

            case "AUTOMOBILE":
                ContratAutomobile contratAutomobile = new ContratAutomobile(contrat);

                String modele = request.getParameter("modele").toString();
                String immat = request.getParameter("immat").toString();
                String conducteur = request.getParameter("conducteur").toString();

                contratAutomobile.setModeleAutomobile(modele);
                contratAutomobile.setImmatriculation(immat);
                contratAutomobile.setNomConducteurPrincipal(conducteur);

                contratRemote.add(contratAutomobile);
                break;

            case "VIE":
                ContratVie contratVie = new ContratVie(contrat);
                int duree = Integer.parseInt(request.getParameter("duree").toString());
                double capital = Double.parseDouble(request.getParameter("capital").toString());

                contratVie.setDureeCotisationMin(duree);
                contratVie.setMontantCapital(capital);

                contratRemote.add(contratVie);
                break;

            case "HABITATION":
                ContratHabitation contratHabitation = new ContratHabitation(contrat);
                double montantMax = Double.parseDouble(request.getParameter("montantMax").toString());
                String adresse = request.getParameter("adresse").toString();

                contratHabitation.setMontantAssureMax(montantMax);
                contratHabitation.setAdresse(adresse);

                contratRemote.add(contratHabitation);
                break;
        }

        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
