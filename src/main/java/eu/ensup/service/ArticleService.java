package eu.ensup.service;

import eu.ensup.dao.IDao;
import eu.ensup.domaine.Article;

public class ArticleService {
    private IDao idao;

    public ArticleService(IDao idao){
        super();
        this.idao = idao;
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


    public IDao getiDao() {
        return idao;
    }

    public void setiDao(IDao iDao) {
        this.idao = iDao;
    }

    public void initialisation() {
        System.out.println("SERVICE: creation spring");
    }

    public void destruction() {
        System.out.println("SERVICE: destruction spring");
    }
}
