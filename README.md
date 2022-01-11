# GestionArticle


### Pratiquer SpringBoot au travers d'un tutoriel.

**Version 1 :** couplage fort<br>
**Version 2 :** couplage faible<br>
**Version 3 :** Conteneur Spring XML<br>
**Version 4 :** Conteneur Spring JAVA<br>
**Version 5 :** DAO classique<br>
**Version 6 :** DAO avec injection DataSource<br>
**Version 7 :** externalisation informations Database<br>
**Version 8 :**  DAO avec injection JdbcTemplate<br>
**Version 9 :** conteneur XML mais beans déclarés par Annotation<br>
**Version 10 :** mise en oeuvre de Spring Boo<br>
**Version 11 :** premier pas Webservice REST (uniquement couche présentation) avec Spring Boot<br>
**Version 12 :** Webservice REST (présentation + Service + Dao) avec Spring Boot<br>
**Version 13 :** (A FAIRE) : Mise en oeuvre Spring MVC sans Spring Boot<br>
**Version 14 :** (A FAIRE) : Mise en oeuvre Spring MVC avec Spring Boot<br>

### Organisation

Chaque version correspondra à un tag github **(exemple Version 1 = tag v1)**. Cela facilitera le passage d'un projet à un autre.<br>

### Analyse de chaque version

***Version 1 :*** le couplage fort s'apparente à l'instanciation (new) de la classe CompteDao au sein de la classe CompteService. Cela contraint l'utilisation de la classe CompteDao uniquement pour l'utilisation de la classe CompteService.

***Version 2 :*** le couplage faible s'apparente à l'utilisation d'une interface dao (pas de new). 2 Classes, CompteDao et CompteDaoJpa sont créées à partir de cette interface. Dans la classe de service CompteService, ont utilisation l'interface DAO. Cela permet de décider du type de dao avant l'instanciation du service.

***Version 3 :*** Dans cette version, un conteneur spring est définit au format XML permettant de mettre en oeuvre l'injection de dépendant du dao dans le service. Cette version met également en évidence la gestion du cycle de vie du dao et du service par Spring.

***Version 4 :*** Dans cette version, l'injection de dépendance est définit dans une classe contrairement à la version 3 ou ce dernier était défini dans un fichier XML. De ce fait, le chargement du conteneur se fait en instanciant un objet AnnotationConfigApplicationContext.

***Version 5 :*** Dans cette version, la dao est rendu effective en créant une base de données PostgreSQL. Dans notre projet, nous avons utilisé MySQL parce qu'il était déjà installé sur nos machines. Les éléments de connexion à la base de données sont définies en dure dans le dao. 

***Version 6 :*** Cette version externalise les informations de connexion à la base de données vers le fichier de configuration XML du conteneur.

***Version 7 :*** Cette version permet d'externaliser les informations de connexion à la base de données en dehors du fichier de configuration du conteneur XML dans un fichier au format .properties . La datasource évolue donc est les informations de connexion fournies dans le fichier de configuration XML sera variable selon le fichier db.properties.

***Version 8 :*** Cette version rend l'éxécution des requêtes plus léger grâce à JdbcTemplate. Elle permet d'éxécuter une requête en quelque ligne sans prendre en compte la gestion des exceptions.

***Version 9 :*** Cette version met en oeuvre l'autocablage de la dao et du service grâce aux annotations @Repository pour le dao et @Service pour le service.


### Projet

Nous avons choisis pour notre projet la gestion des articles alimentaires.

Pour la base de données, nous avons créé une table simple avec les colonnes suivantes :

 - Name
 - Quantity
 - Price
 - Category
 - Code **[Primary Key]**
