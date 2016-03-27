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
    <title>Supression d'un contrat type</title>
</head>
<body>

<form action="/contrat/type/delete" method="POST">

    Utilisateurs :

    <select name="id">
        <c:forEach items="${contratTypes}" var="u">
            <option value="${u.id}">${u.categorieContrat} - ${u.id}</option>
        </c:forEach>
    </select><br/>

    <input type="submit" value="Supprimer"/><br/>
</form>
</body>
</html>
