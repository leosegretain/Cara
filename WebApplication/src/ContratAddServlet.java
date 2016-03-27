import beans.ContratRemote;
import beans.ContratTypeRemote;
import beans.UserRemote;
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
@WebServlet(name = "ContratAddServlet", urlPatterns = "/contratAdd")
@ServletSecurity(
        @HttpConstraint(transportGuarantee =
                ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"COURTIER"}))
public class ContratAddServlet extends HttpServlet {

    @EJB(beanName = "ContratEJB")
    private ContratRemote contratRemote;

    @EJB(beanName = "UserEJB")
    private UserRemote userRemote;

    @EJB(beanName = "ContratTypeEJB")
    private ContratTypeRemote contratTypeRemote;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String assureName = request.getParameter("assure").toString();
        int typeContratId = Integer.parseInt(request.getParameter("typeContrat").toString());
        double montant = Double.parseDouble(request.getParameter("montant").toString());

        Contrat contrat = new Contrat();

        TypeContrat typeContrat = contratTypeRemote.findById(typeContratId);
        CaraUser caraUser = userRemote.findByName(assureName);

        contrat.setTypeContrat(typeContrat);
        contrat.setUserAssure(caraUser);

        try {
            contrat.setMontant(montant);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaraUser user = (CaraUser) request.getSession().getAttribute("user");

        if (user != null) {

            List<CaraUser> assures = userRemote.listAssures();
            List<TypeContrat> types = contratTypeRemote.list();

            request.setAttribute("assures", assures);
            request.setAttribute("contratTypes", types);
            request.getRequestDispatcher("contratAdd.jsp").forward(request, response);
        }
    }
}
