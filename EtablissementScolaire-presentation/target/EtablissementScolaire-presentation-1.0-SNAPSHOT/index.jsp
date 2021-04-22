<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

</head>
<body>
<main>
    <div class="container-fluid d-flex justify-content-center">
        <div class="card shadow-lg">
        <form class="form" action="infos">
            <fieldset class="form-row ">
                <h2>Connexion</h2>
                <form  >
                    <div class="form-group input">
                        <label for="identifiant">Nom:</label>
                        <input class="form-control" id="identifiant" placeholder="Nom" name="nom">
                    </div>
                    <div class="form-group input">
                        <label for="Prenom">Prenom:</label>
                        <input class="form-control" id="Prenom" placeholder="Prenom" name="prenom">
                    </div>
                    <div class="form-group input">
                        <label for="Email">Email:</label>
                        <input class="form-control" type="email" id="Email" placeholder="Email" name="email">
                    </div>
                    <div class="form-group input">
                        <label for="Login">Login:</label>
                        <input class="form-control" id="Login" placeholder="Login" name="login">
                    </div>
                    <div class="form-group input">
                        <label for="password">Mot de passe:</label>
                        <input class="form-control" type="password"  id="password" placeholder="Mot de passe" name="password">
                    </div>
                    <div class="form-group input">
                        <input formmethod="get" class="btn btn-primary btn-form" type="submit"  id="btnValider">
                    </div>
        </form>
        </fieldset>
    </form>
    </div>
    </div>
</main>
</body>
</html>