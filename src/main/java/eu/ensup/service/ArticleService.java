package eu.ensup.service;

import eu.ensup.dao.IDao;
import eu.ensup.domaine.Article;

import java.util.ArrayList;

public class ArticleService {
    private IDao idao;

    public ArticleService(){
        super();
    }
    public ArticleService(IDao idao){
        super();
        this.idao = idao;
    }

    public void setIdao(IDao idao){
        this.idao = idao;
    }

    public IDao getIdao() {
        return idao;
    }

    public Article get(String reference){
        System.out.println("SERVICE: Récupération de l'article id=" + reference);

        Article articleget = idao.get(reference);
        return articleget;
    }

    public void create(Article article){
        System.out.println("SERVICE: Création de l'article : " + article.toString());

        idao.create(article);

    }

    public Article update(Article article){
        System.out.println("SERVICE: Update de l'article : " + article.toString());

        Article articleupdate = idao.update(article);
        return articleupdate;
    }

    public void delete(String reference){
        System.out.println("SERVICE: Delete de l'article : " + reference);

        idao.delete(reference);
    }


    public ArrayList<Article> getAll(){
        System.out.println("SERVICE: Récupération de tous les articles ");

        ArrayList<Article> articleget = idao.getAll();
        return articleget;
    }
    public void initialisation() {
        System.out.println("SERVICE: creation spring");
    }

    public void destruction() {
        System.out.println("SERVICE: destruction spring");
    }
}
