package eu.ensup.dao;

import eu.ensup.domaine.Article;

public class ArticleDaoJpa implements IDao {
    @Override
    public Article get(String reference) {
        System.out.println("DAO: Récupération de l'article " + reference);
        if (reference == "ref-bonbon-002") {
            return new Article("Haribo", 10, 12.5f,"bonbon","ref-bonbon-001"); // MOCK SGBDR
        }
        return null;
    }

    @Override
    public Integer create(Article article) {
        System.out.println("DAO: Creation de l'article " + article.toString());
        return null;
    }

    @Override
    public Article update(Article article) {
        System.out.println("DAO: Update de l'article " + article.toString());
        return null;
    }

    @Override
    public Integer delete(String reference) {
        System.out.println("DAO: Suppression de l'article " + reference);
        return null;
    }
}
