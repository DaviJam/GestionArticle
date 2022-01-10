package eu.ensup.launcher;

import eu.ensup.container.BeansServiceConfig;
import eu.ensup.container.BeansDaoConfig;
import eu.ensup.domaine.Article;
import eu.ensup.service.ArticleService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {

        // 1. Chargement du conteneur en 4.0.0 Spring
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) new ClassPathXmlApplicationContext(
                "daobeans.xml","servicebeans.xml");

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
