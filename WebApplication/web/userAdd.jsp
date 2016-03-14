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
    <title>Ajout d'un utilisateur</title>
</head>
<body>
<form action="/WebApplication/userAdd" method="POST">

    Nom : <input type="text" name="nom"/> <br/>
    Prénom : <input type="text" name="prenom"/><br/>
    E-mail : <input type="text" name="email"/><br/>
    Mot de passe : <input type="text" name="motdepasse"/><br/>
    Adresse : <input type="text" name="adresse"/><br/>
    Type : <select name="dtype">
        <option value="ADMIN">Administrateur</option>
        <option value="ASSURE">Assuré</option>
        <option value="COURTIER">Courtier</option>
    </select><br/>
    <input type="submit" value="Ajouter" /><br/>
</form>
</body>
</html>
