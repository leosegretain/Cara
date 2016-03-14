<%--
  Created by IntelliJ IDEA.
  User: Léo
  Date: 09/02/2016
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bienvenue ${sessionScope.user.nom}</title>
</head>
<body>
Salut ${user.nom} <a class="button" href="/WebApplication/logout">Se déconnecter</a>

<a class="button" href="/WebApplication/userAdd">Ajouter un user (Admin)</a>


</body>
</html>
