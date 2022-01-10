# GestionArticle

Pratiquer SpringBoot au travers d'un tutoriel.

Version 1 : couplage fort<br>
Version 2 : couplage faible<br>
Version 3 : Conteneur Spring XML<br>
Version 4 : Conteneur Spring JAVA<br>
Version 5 : DAO classique<br>
Version 6 : DAO avec injection DataSource<br>
Version 7 : externalisation informations Database<br>
Version 8 :  DAO avec injection JdbcTemplate<br>
Version 9 : conteneur XML mais beans déclarés par Annotation<br>
Version 10 : mise en oeuvre de Spring Boo<br>
Version 11 : premier pas Webservice REST (uniquement couche présentation) avec Spring Boot<br>
Version 12 : Webservice REST (présentation + Service + Dao) avec Spring Boot<br>
Version 13 (A FAIRE) : Mise en oeuvre Spring MVC sans Spring Boot<br>
Version 14 (A FAIRE) : Mise en oeuvre Spring MVC avec Spring Boot<br>

### Organisation

Chaque version correspondra à un tag github (exemple Version 1 = tag v1). Cela facilitera le passage d'un projet à un autre.<br>

Version 1 : le couplage fort s'apparente à l'instanciation (new) de la classe CompteDao au sein de la classe CompteService. Cela contraint l'utilisation de la classe CompteDao uniquement pour l'utilisation de la classe CompteService. <br>
Version 2 : le couplage faible s'apparente à l'utilisation d'une interface dao (pas de new). 2 Classes, CompteDao et CompteDaoJpa sont créées à partir de cette interface. Dans la classe de service CompteService, ont utilisation l'interface DAO. Cela permet de décider du type de dao avant l'instanciation du service.
Version 3 : 

Version 4 : Dans cette version, l'injection de dépendance est définit dans une classe contrairement à la version 3 ou ce dernier était défini dans un fichier XML. De ce fait, le chargement du conteneur se fait en instanciant un objet AnnotationConfigApplicationContext.


### Projet
Permettre la gestion d'article dans un magasion d'alimentation générale. 
