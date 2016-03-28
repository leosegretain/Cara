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
    <title>Contrats en attente de ${user.nom}</title>
</head>
<body>

    <p>
        Demandes en attente :
        <table>
            <thead>
                <th>Référence</th>
                <th>Type</th>
                <th>Catégorie</th>
                <th>Montant</th>
                <th>Etat</th>
                <th></th>
            </thead>

            <tbody>
            <c:forEach items="${contratsEnAttente}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.typeContrat.id}</td>
                    <td>${c.typeContrat.categorieContrat}</td>
                    <td>${c.montant}</td>
                    <td>${c.etat}</td>
                    <td>
                        <c:if test="${c.etatNumber == 1}">
                            <form action="/courtier/valider" method="post">
                                <input type="hidden" value="${c.id}" name="contrat"/>
                                Montant de cotisation : <input type="number" name="montant"/><br/>
                                <input type="submit" value="Valider le contrat">
                            </form>s
                        </c:if>

                        <c:if test="${c.etatNumber == 0}">
                            <form action="/courtier/supprimer" method="post">
                                <input type="hidden" value="${c.id}" name="contrat"/>
                                <input type="submit" value="Confirmer la suppression">
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </p>

</body>
</html>
