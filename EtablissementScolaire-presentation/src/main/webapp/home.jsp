<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Appli étudiant</title>
    <link href="css/style.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script type="text/javascript" src="assets/js/app.js"  defer> </script>
</head>

<body>
  <%
      if (session.getAttribute("user") != null) {
          %>
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon"></span>
         </button>
         <div class="collapse navbar-collapse" id="navbarNav">
           <ul class="navbar-nav">
             <li class="nav-item">
               <a class="nav-link" href="createUser.jsp">CRÉER ÉTUDIANT</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="setCourse.jsp">ATTRIBUER COURS</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link" href="userList.jsp">LISTE DES ÉTUDIANTS</a>
               </li>
             <li class="nav-item">
                 <a class="nav-link" href="login.jsp">DÉCONNEXION</a>
               </li>
           </ul>
         </div>
       </nav>
             <%
          }
       %>
  <main>
      <div class="container-fluid d-flex justify-content-center" >
          <div class="card shadow-lg">
                  <fieldset class="form-row">
                      <h2>Accueil</h2>
                          <div class="form-group btn-center">
                              <a href="createUser.jsp" class="col-12"> <button type="button" class="btn btn-primary btn-form col-12">Ajouter un étudiant</button></a>
                          </div>
                          <div class="form-group btn-center ">
                              <form action="editEtudiant">    <button formmethod="post" type="submit" class="btn btn-primary btn-form col-12">Editer un étudiant</button></form>
                          </div>
                          <div class="form-group btn-center">
                              <form action="setCourse"> <button type="submit" formmethod="post" class="btn btn-primary btn-form col-12">Associer un cours à un étudiant</button></form>
                          </div>
                          <div class="form-group btn-center">
                              <form action="etudiantList">  <button formmethod="get" type="submit" class="btn btn-primary btn-form col-12">Lister les étudiants</button> </form>
                          </div>
                          <div class="form-group btn-center">
                              <a href="addNoteEtudiant.jsp" class="col-12"> <button type="button" class="btn btn-primary btn-form col-12">Ajouter une note</button></a>
                          </div>
                          <div class="form-group btn-center">
                              <a href="stat.jsp" class="col-12"> <button type="button" class="btn btn-primary btn-form col-12">Statistiques</button></a>
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