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
    <title>Ajout d'un contrat</title>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form action="/WebApplication/contratAdd" method="POST">

    Information contrat :
    <p>
        Type de contrat :
        <select name="typeContrat">
            <c:forEach items="${contratTypes}" var="u">
                <option value="${u.id}">${u.categorieContrat} - ${u.id}</option>
            </c:forEach>
        </select><br/>

        Montant : <input type="number" name="montant"/><br/>

        Assuré :
        <select name="assure">
            <c:forEach items="${assures}" var="u">
                <option value="${u.nom}">${u.nom}</option>
            </c:forEach>
        </select><br/>
    </p>

    Information Auto (si Contrat Automobile) :
    <p>
        Modèle voiture : <input type="text" name="modele"/><br/>
        Immatriculation : <input type="text" name="immat"/><br/>
        Conducteur principal : <input type="text" name="conducteur"/><br/>
    </p>

    Information Vie (si Contrat Vie) :
    <p>
        Montant capital : <input type="number" name="capital"/><br/>
        Durée de cotisation : <input type="number" name="duree"/><br/>
    </p>

    Information Habitation (si Contrat Habitation) :
    <p>
        Montant maximum : <input type="number" name="montantMax"/><br/>
        Adresse : <input type="text" name="adresse"/><br/>
    </p>

    <input type="submit" value="Ajouter"/><br/>
</form>
</body>
</html>
