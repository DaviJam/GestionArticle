package eu.ensup.launcher;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.ensup.domaine.Article;
import eu.ensup.service.ArticleService;

public class Launcher {

    public static void main(String[] args) {


        ///
        // 1. Chargement du conteneur en 4.0.0 Spring
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) new ClassPathXmlApplicationContext(
                "demo-beans.xml");

        // 2. Recuperation d'un bean du conteneur
        ArticleService articleService = (ArticleService) applicationContext.getBean("articleService");


        // 3. Manipulation du bean avec injection de dependances
        Article article1 = new Article("Haribo", 10, 12.5f,"bonbon","ref-bonbon-001");
        articleService.create(article1);


        Article article2 = articleService.get("ref-bonbon-001");
        if (article2 != null) {
            System.out.println("LAUNCHER: Récuperation du article réussie " + article2.toString());
        } else {
            System.out.println("LAUNCHER: R�cuperation du article échouée");
        }
        applicationContext.close();
    }

}
