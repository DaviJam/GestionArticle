package eu.ensup.service;

import eu.ensup.dao.ArticleDao;
import eu.ensup.domaine.Article;

public class ArticleService {

    private ArticleDao dao;
    public ArticleService() {
        this.dao = new ArticleDao();
    }

    Integer create(Article article){
        return this.dao.create(article);
    }

    Article get(String reference){
        return this.dao.get(reference);
    }

    Integer update(Article article){
        return this.dao.update(article);
    }

    Integer delete(String reference){
        return this.dao.delete(reference);
    }
}
