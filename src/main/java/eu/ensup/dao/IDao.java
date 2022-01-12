package eu.ensup.dao;

import eu.ensup.domaine.Article;

import java.util.ArrayList;

public interface IDao {

    Article get(String reference);

    Integer create(Article article);

    Article update(Article article);

    Integer delete(String reference);

    ArrayList getAll();
}
