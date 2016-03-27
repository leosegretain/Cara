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
        Clients :
        <table>
            <thead>
                <th>Nom</th>
                <th>Email</th>
                <th></th>
            </thead>

            <tbody>
                <c:forEach items="${clients}" var="c">
                    <tr>
                        <td>${c.nom}</td>
                        <td>${c.email}</td>
                        <td>
                            <form action="/courtier/client/contrats" method="POST">
                                <input type="hidden" name="client" value="${c.nom}">
                                <button type="submit">Contrats</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </p>

</body>
</html>
