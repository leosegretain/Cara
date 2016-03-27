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
    <title>Ajout d'un contrat type</title>
</head>
<body>
<form action="/WebApplication/contratTypeAdd" method="POST">

    Catégorie :

    <select name="categorie">
        <option value="AUTOMOBILE">AUTOMOBILE</option>
        <option value="VIE">VIE</option>
        <option value="HABITATION">HABITATION</option>
    </select><br/>

    Description : <input type="text" name="description"/><br/>
    Montant minimal : <input type="number" name="montantMin"/><br/>

    <input type="submit" value="Ajouter"/><br/>
</form>
</body>
</html>
