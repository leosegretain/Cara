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
                            <button type="submit">Stopper</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

</body>
</html>
