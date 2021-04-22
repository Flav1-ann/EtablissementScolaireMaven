<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Appli étudiant</title>
    <link href="assets/css/styles.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script type="text/javascript" src="assets/js/app.js" defer></script>
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
               <a class="nav-link" href="#">CRÉER ÉTUDIANT</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="#">ATTRIBUER COURS</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link" href="#">LISTE DES ÉTUDIANTS</a>
               </li>
             <li class="nav-item">
                 <a class="nav-link" href="#">DÉCONNEXION</a>
               </li>
           </ul>
         </div>
       </nav>
             <%
          }
       %>
    <main class="container-fluid">
        <div class="row h-100">

            <div class="col-4 d-none d-lg-block"></div>

            <div class="col-lg-4 col-12 my-auto">
                <div class="row form_div">
                    <h2 class="col-12">Créer un étudiant</h2>
                    <form class="student_form col-12" action="etudiantAdd">
                        <div class="row">
                            <div class="form-group col-12">
                                <label for="lastName">Nom</label>
                                <input type="text" placeholder="nom" class="form-control" name="lastName" id="lastName">
                            </div>

                            <div class="form-group col-12">
                                <label for="firstName">Prenom</label>
                                <input type="text" placeholder="prénom" class="form-control" name="firstName"
                                    id="firstName">
                            </div>

                            <div class="form-group col-12">
                                <label for="address">Adresse</label>
                                <input type="text" placeholder="adresse" class="form-control" name="address"
                                    id="address">
                            </div>

                            <div class="form-group col-12">
                                <label for="phone">Téléphone</label>
                                <input type="text" placeholder="tel" class="form-control" name="phone" id="phone">
                            </div>

                            <div class="form-group col-12">
                                <label for="birthDate">Date de naissance</label>
                                <input type="date" name="birthDate" class="form-control" id="birthDate">
                            </div>

                            <div class="form-group col-12">
                                <label for="email">Email</label>
                                <input type="text" placeholder="email" class="form-control" name="email" id="email">
                            </div>

                            <div class="form_error col-12">
                                <p id="form_info_text"></p>
                            </div>

                            <div class="form_input col-12 ">
                                <input class="btn btn-primary submit-btn" formmethod="post"  type="submit" value="Envoyer">
                            </div>

                        </div>


                    </form>
                </div>

            </div>

            <div class="col-4 d-none d-lg-block"></div>

        </div>




        </div>
    </main>
</body>
</html>