package eu.ensup.launcher;

import eu.ensup.dao.ArticleDao;
import eu.ensup.dao.ArticleDaoJpa;
import eu.ensup.dao.IDao;
import eu.ensup.domaine.Article;
import eu.ensup.service.ArticleService;

public class Launcher {

    public static void main(String[] args) {
        Article article = new Article("Haribo", 10, 12.5f,"bonbon","ref-bonbon-001");

        IDao idao = new ArticleDao();
        IDao idaoJpa = new ArticleDaoJpa();
        ArticleService articleService = new ArticleService(idao);
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
