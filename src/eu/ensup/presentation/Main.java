package eu.ensup.presentation;

import eu.ensup.domaine.Article;
import eu.ensup.service.ArticleService;

public class Main {

    public static void main(String[] args) {

        // Article {nom, qty, prix unitaire, categorie, référence}
        Article article = new Article("Haribo", 25, 2.5f, "Bonbon", "ref-sec-001");
        ArticleService service = new ArticleService();
        service.create(article);

    }
}
