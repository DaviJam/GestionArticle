package eu.ensup.dao;

import eu.ensup.domaine.Article;

public class ArticleDao {
    public ArticleDao() {
    }
    public Integer create(Article article){
        System.out.println("New article "+article.getReference()+" added to database.");
        return 0;
    }
    public Article get(String reference){
        System.out.println("Article "+reference+" retrieved from database.");
        return new Article("Olive", 10, 3.5f, "Sec", "ref-sec-002");
    }
    public Integer update(Article article){
        System.out.println("Article "+article.getReference()+" updated.");
        return 0;
    }
    public Integer delete(String reference){
        System.out.println("Article "+reference+" deleted from database.");
        return 0;
    }

}
