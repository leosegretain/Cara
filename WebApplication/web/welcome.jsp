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
Salut ${user.nom}

<br/>
<a class="button" href="/WebApplication/logout">Se déconnecter</a><br/>

<a class="button" href="/WebApplication/userAdd">Ajouter un user (Admin)</a><br/>
<a class="button" href="/WebApplication/userDel">Supprimer un user (Admin)</a><br/>

<a class="button" href="/WebApplication/contratTypeAdd">Ajouter un type de contrat (Admin)</a><br/>
<a class="button" href="/WebApplication/contratTypeDel">Supprimer un type de contrat (Admin)</a><br/>

<a class="button" href="/WebApplication/contratAdd">Ajouter un contrat (Courtier)</a><br/>
<a class="button" href="/WebApplication/contratDel">Supprimer un contrat (Courtier)</a><br/>

</body>
</html>
