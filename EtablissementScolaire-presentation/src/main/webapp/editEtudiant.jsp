<%@ page import="eu.ensup.etablissementscolaire.Etudiant" %>
<%@ page import="java.util.Set" %>
<%@ page import="eu.ensup.etablissementscolaire.Etudiant" %>
<%--
  Created by IntelliJ IDEA.
  User: Flavien
  Date: 22/04/2021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un éléve</title>
    <link href="css/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script type="text/javascript" src="css/app.js" defer></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="home.html">Accueil</a>
            <a class="nav-item nav-link active" href="frmEtudiant.html">Ajouter un étudiant</a>
            <a class="nav-item nav-link disabled" href="listEtudiant.html">Lister les étudiants</a>
        </div>
    </div>
</nav>
<main>
    <div class="container-fluid d-flex justify-content-center" >
        <div class="card shadow-lg">
                <fieldset class="form-row input">

                    <h2>Modification d'un éléve</h2>
                    <div class="form-group" >
                        <label for="dropPicker">Sélectionner un étudiant</label>
                        <select class="form-control" id="dropPicker">
                            <option></option>

                            <% for(Etudiant e : (Set<Etudiant>) session.getAttribute("listEtudiant")){ %>
                                <option value="<%= e %>"><%= e.getNom() + " " +e.getPrenom() %></option>
                            <% } %>

                        </select>
                    </div>
                    <div class="form-group input">
                        <label for="name">Nom:</label>
                        <input  class="form-control" id="name" placeholder="Nom" name="name">
                    </div>

                    <div class="form-group input">
                        <label for="lastName">Prénom:</label>
                        <input  class="form-control" id="lastName" placeholder="Prénom" name="lastName">
                    </div>

                    <div class="form-group input">
                        <label for="address">Adresse:</label>
                        <input  class="form-control" id="address" placeholder="Adresse" name="adress">
                    </div>

                    <div class="form-group input">
                        <label for="phone">Téléphone:</label>
                        <input  class="form-control" id="phone" placeholder="N° de téléphone" name="phone">
                    </div>

                    <div class="form-group input">
                        <label for="birthday">Date de naissance:</label>
                        <input type="date" class="form-control" id="birthday" placeholder="Date de naissance" name="birthday">
                    </div>

                    <div class="form-group input">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
                    </div>

                    <div class="form-group btn-center" >
                         <form action=""><button type="button" class="btn btn-primary btn-form-udpate" id="btnUpdate" >Modifier</button></form>
                        <button type="button" class="btn btn-danger btn-form-udpate" id="">Annuler</button>
                    </div>

                    <div class="form-group">
                        <p id="alert"></p>
                    </div>
                </fieldset>
        </div>
    </div>
</main>
</body>
</html>
