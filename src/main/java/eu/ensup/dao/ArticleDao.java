package eu.ensup.dao;

import eu.ensup.domaine.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class ArticleDao implements IDao {

    private DataSource dataSource;
    private String driverName = "com.mysql.cj.jdbc.Driver";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Article get(String code) {
        Object[] obj = new Object[1];
        obj[0] = code;
        return (Article) jdbcTemplate.queryForObject("SELECT * FROM article WHERE code=?",obj,
                (resultSet, rowNum) -> {
                    Article article = new Article(
                            resultSet.getString("name"),
                            resultSet.getInt("quantity"),
                            resultSet.getFloat("price"),
                            resultSet.getString("category"),
                            resultSet.getString("code"));
                    return article;
                });
    }

    @Override
    public Integer create(Article article) {

        Object[] arguments = new Object[5];
        arguments[0] = article.getName();
        arguments[1] = article.getQuantity();
        arguments[2] = article.getPrice();
        arguments[3] = article.getCategory();
        arguments[4] = article.getCode();
        int result = jdbcTemplate.update("INSERT INTO article(name, quantity, price, category, code) VALUES(?,?,?,?,?)", arguments);

        return result;
    }

    @Override
    public Article update(Article article) {
        System.out.println("DAO: Update de l'article " + article.toString());

        Object[] arguments = new Object[2];
        arguments[0] = article.getQuantity();
        arguments[1] = article.getCode();
        int result = jdbcTemplate.update("UPDATE article SET quantity = ? WHERE code = ?", arguments);

        if(result == 1){return article;}
        return null;
    }

    @Override
    public Integer delete(String code) {
        System.out.println("DAO: Suppression de l'article " + code);

        Object[] arguments = new Object[1];
        arguments[0] = code;

        return jdbcTemplate.update("DELETE FROM article WHERE code = ?", arguments);
    }

    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
