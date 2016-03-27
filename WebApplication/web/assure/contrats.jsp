<%--
  Created by IntelliJ IDEA.
  User: Léo
  Date: 09/02/2016
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Contrats de ${user.nom}</title>
</head>
<body>

    <p>
        <form action="/assure/demande" method="POST">

            Information contrat :
            <p>
                Type de contrat :
                <select name="typeContrat">
                    <c:forEach items="${contratTypes}" var="u">
                        <option value="${u.id}">${u.categorieContrat} - ${u.id}</option>
                    </c:forEach>
                </select><br/>

                Montant : <input type="number" name="montant"/><br/>
            </p>

            Information Auto (si Contrat Automobile) :
            <p>
                Modèle voiture : <input type="text" name="modele"/><br/>
                Immatriculation : <input type="text" name="immat"/><br/>
                Conducteur principal : <input type="text" name="conducteur"/><br/>
            </p>

            Information Vie (si Contrat Vie) :
            <p>
                Montant capital : <input type="number" name="capital"/><br/>
                Durée de cotisation : <input type="number" name="duree"/><br/>
            </p>

            Information Habitation (si Contrat Habitation) :
            <p>
                Montant maximum : <input type="number" name="montantMax/><br/>
                Adresse : <input type="text" name="adresse"/><br/>
            </p>

            <input type="submit" value="Demander un nouveau contrat"/><br/>
        </form>
    </p>

    <p>
        Contrat en cours :
        <table>
            <thead>
                <th>Référence</th>
                <th>Type</th>
                <th>Catégorie</th>
                <th>Montant</th>
                <th></th>
            </thead>

            <tbody>
                <c:forEach items="${contrats}" var="c">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.typeContrat.id}</td>
                        <td>${c.typeContrat.categorieContrat}</td>
                        <td>${c.montant}</td>
                        <td>
                            <form action="/assure/stop" method="POST">
                                <input type="hidden" name="contrat" value="${c.id}">
                                <button type="submit">Stopper</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </p>

    <p>
        Demandes en attente :
        <table>
            <thead>
                <th>Référence</th>
                <th>Type</th>
                <th>Catégorie</th>
                <th>Montant</th>
                <th>Etat</th>
            </thead>

            <tbody>
            <c:forEach items="${contratsEnAttente}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.typeContrat.id}</td>
                    <td>${c.typeContrat.categorieContrat}</td>
                    <td>${c.montant}</td>
                    <td>${c.etat}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </p>

</body>
</html>
