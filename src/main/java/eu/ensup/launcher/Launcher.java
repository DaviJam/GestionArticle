package eu.ensup.launcher;

import eu.ensup.container.DemoBeansConfig;
import eu.ensup.dao.ArticleDao;
import eu.ensup.dao.ArticleDaoJpa;
import eu.ensup.dao.IDao;
import eu.ensup.domaine.Article;
import eu.ensup.service.ArticleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static void main(String[] args) {

        // 1. Chargement du conteneur en 4.0.0 Spring
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoBeansConfig.class);

        // 2. Recuperation d'un bean du conteneur
        ArticleService articleService = (ArticleService) applicationContext.getBean("articleService");

        // 3. Manipulation du bean avec injection de dependances
        Article article = new Article("Haribo", 10, 12.5f,"bonbon","ref-bonbon-001");
        articleService.create(article);

        Article article2 = articleService.get("ref-bonbon-001");
        if(article2 != null){
            System.out.println("LAUNCHER: Récupération de l'article réussie : " + article2.toString());
        } else
        {
            System.out.println("LAUNCHER: Récupération de l'article échouée");
        }
    }

}
