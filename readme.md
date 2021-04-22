# Les test unitaires

## Prérequis

- Avoir java avec le jdk et jre 15
- Avoir maven d'installer

## Lancement

Il y a des tests de la couche dao et un test de la couche service

Vous trouverez la classe de test de la couche DAO dans le fichier suiviant : `EtablissementScolaire-dao/src/test/java/eu.ensup.etablissementscolaire/DaoTest.java.java`
Vous trouverez la classe de test de la couche service dans le fichier suiviant : `EtablissementScolaire-service/src/test/java/eu.ensup.etablissementscolaire/ServiceTest.java`

Pour que les tests de la couche dao fonctionne il faut une base de donnée MYSQL avec le base de données du projet. Vous trouverez le dump dans le dossier `DB` à la racine du projet.

Pour lancer seuleument les tests de la couche service vous devez d'abord accéder au dossier `EtablissementScolaire-service` du projet dans une invite de commande (winodws) ou un terminal (linux et MacOS).

Ensuite executez la commande : `mvn clean test` pour lancer les tests.

