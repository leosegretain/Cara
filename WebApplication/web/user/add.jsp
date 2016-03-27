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
    <title>Ajout d'un utilisateur</title>
</head>
<body>
<form action="/user/add" method="POST">

    Nom : <input type="text" id="nom" name="nom"/> <br/>
    Prénom : <input type="text" name="prenom"/><br/>
    E-mail : <input type="text" name="email"/><br/>
    Mot de passe : <input type="text" name="motdepasse"/><br/>
    Adresse : <input type="text" name="adresse"/><br/>
    Type :
    <select name="dtype">
        <option value="ADMIN">Administrateur</option>
        <option value="ASSURE">Assuré</option>
        <option value="COURTIER">Courtier</option>
    </select><br/>

    Courtier responsable (Si Assuré) :
    <select name="courtier">
        <c:forEach items="${courtiers}" var="u">
            <option value="${u.nom}">${u.nom}</option>
        </c:forEach>
    </select><br/>

    <input type="submit" value="Ajouter"/><br/>
</form>
</body>
</html>
