-------------------------------- INSTRUCTIONS DE MISE EN MARCHE -------------------------------

Dans ce code JAVA JEE, nous avons une application Spring Boot Micro-Service qui fonctionne avec une API SERVER REST et une API CLIENT REST WEB.
Elle consiste à gérer les liens d'autres API qui y seront repertoriés. 
Ce n'est pas une API MANAGEMENT complète en tant que tel, mais l'idée principale y est ! Quit à vous de la développer, d'avantage !

Pour accéder à l'API SERVER REST, on passe via l'API CLIENT REST avec une interface WEB accéssible via le lien: http://localhost:9095/
Faudra au préalable, créer une BASE DE DONNEES sur POSTGREQSL nommée "api_manager". Car, c'est ainsi qu'elle a été configuré sur l'API SERVER REST.

1) Créer la base de donnée "api_manager" sur PostGreSQL et la laisser active.
2) D'abord lancer l'API SERVER REST, sur l'IDE utilisé. Dans notre cas, c'est ECLIPSE.
3) Ensuite lancer l'API CLIENT REST WEB, sur l'IDE: ECLIPSE.
4) Aller enfin sur votre navigateur et taper le lien: http://localhost:9095/ pour la mise en marche.

C'est prêt! L'application est fonctionnelle et prête à être utilisé !

NB: Ce code ne contient pas de JAR pour le déployement en prod. Il faudra le générer, si besoin.

Enjoy ! :) 
