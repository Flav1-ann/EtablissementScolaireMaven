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
    <body>
        étudiant a été créer avec succès !
        <p>
            nom : ${ etudiant.nom } <br/>
            prénom : ${ etudiant.prenom } <br/>
            email : ${ etudiant.email } <br/>
            adresse : ${ etudiant.prenom } <br/>
            telephone  : ${ etudiant.telephone } <br/>
            Date de naissance : ${ etudiant.dateNaissance } <br/>
        </p>
    </body>
</html>