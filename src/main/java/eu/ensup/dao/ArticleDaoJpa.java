package eu.ensup.dao;

import eu.ensup.domaine.Article;

import java.util.ArrayList;

public class ArticleDaoJpa implements IDao {
    @Override
    public Article get(String reference) {
        System.out.println("DAO: Récupération de l'article " + reference);
        if (reference == "ref-bonbon-001") {
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

    @Override
    public ArrayList<Article> getAll() {
        return null;
    }

    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
