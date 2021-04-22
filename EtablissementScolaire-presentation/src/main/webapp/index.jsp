<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Test html css</title>
        <link rel="stylesheet" type="text/css" href="assets/css/style.css" />
        <meta name="description" content="texte">
        <meta name="robots" content="index,follow">
        <meta name="keywords" content="mots clés">
        <script type="text/javascript" src="assets/js/script.js" defer> </script>
    </head>
    <body >
        <h1 class="center">Ajouter un étudiant</h1>

        <form class="center" action="/etablissement/form" method="POST" >
            <div class="center">
                <label for="nom">Nom : </label>
                <input name="nomE" id="nom" required /><br />
                <label for="prenom">prenom : </label>
                <input name="prenomE" id="prenom" required/><br />
                <label for="adresse">adresse : </label>
                <input name="adresseE" id="adresse" required/><br />
                <label for="email">email : </label>
                <input name="emailE" id="email" required/> <br />
                <label for="password">password : </label>
                <input name="passwordE" id="password" type="password" required/><br />
                <label for="phone">Téléphone : </label>
                <input name="phoneE" d="phone" required/><br />
                <label for="ddn">Date de naissance : </label>
                <input name="ddnE"id="ddn" type="date" required /> <br />
                <input type="submit" value="créer">
            </div>
        </form>
    </body>
</html>