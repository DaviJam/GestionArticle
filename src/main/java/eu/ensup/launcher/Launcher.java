package eu.ensup.launcher;

import eu.ensup.container.BeansServiceConfig;
import eu.ensup.container.BeansDaoConfig;
import eu.ensup.domaine.Article;
import eu.ensup.service.ArticleService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Launcher {

    public static void main(String[] args) {

        // 1. Chargement du conteneur en 4.0.0 Spring
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) new ClassPathXmlApplicationContext(
                "daobeans.xml","servicebeans.xml");

        // 2. Recuperation d'un bean du conteneur
        ArticleService articleService = (ArticleService) applicationContext.getBean("articleService");

        // 3. Manipulation du bean avec injection de dependances
      /*  Article article = new Article("Chocolat", 10, 12.5f,"bonbon","ref-bonbon-003");
        articleService.create(article);*/

        //4.get by code
        Article article2 = articleService.get("ref-bonbon-002");

        //4.get All
        ArrayList<Article> list = articleService.getAll();

        for (Article element : list) {
            System.out.println(element);
        }
        if(article2 != null){
            System.out.println("LAUNCHER: Récupération de l'article réussie : " + article2.toString());
        } else
        {
            System.out.println("LAUNCHER: Récupération de l'article échouée");
        }
    }

}
