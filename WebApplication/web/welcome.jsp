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
<a class="button" href="/user/logout">Se déconnecter</a><br/><br/>

<a class="button" href="/user/add">Ajouter un user (Admin)</a><br/>
<a class="button" href="/user/delete">Supprimer un user (Admin)</a><br/><br/>

<a class="button" href="/contrat/type/add">Ajouter un type de contrat (Admin)</a><br/>
<a class="button" href="/contrat/type/delete">Supprimer un type de contrat (Admin)</a><br/><br/>

<a class="button" href="/contrat/add">Ajouter un contrat (Courtier)</a><br/>
<a class="button" href="/contrat/delete">Supprimer un contrat (Courtier)</a><br/><br/>

<a class="button" href="/assure/contrats">Liste contrats (Assure)</a><br/>
<a class="button" href="/assure/attente/contrats">Liste contrats en attente (Assure)</a><br/>
<a class="button" href="/assure/demandeContrat">Demande de contrat (Assure)</a><br/><br/><br/>saint

</body>
</html>
