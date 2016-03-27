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
    <title>Supression d'un utilisateur</title>
</head>
<body>

<form action="/user/delete" method="POST">

    Utilisateurs :

    <select name="nom">
        <c:forEach items="${users}" var="u">
            <option value="${u.nom}">${u.discriminator} - ${u.nom}</option>
        </c:forEach>
    </select><br/>

    <input type="submit" value="Supprimer"/><br/>
</form>
</body>
</html>
