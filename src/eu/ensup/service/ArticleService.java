package eu.ensup.service;

import eu.ensup.dao.ArticleDao;
import eu.ensup.domaine.Article;

public class ArticleService {

    private ArticleDao dao;
    public ArticleService() {
        this.dao = new ArticleDao();
    }

    public Integer create(Article article){
        return this.dao.create(article);
    }

    public Article get(String reference){
        return this.dao.get(reference);
    }

    public Integer update(Article article){
        return this.dao.update(article);
    }

    public Integer delete(String reference){
        return this.dao.delete(reference);
    }
}
