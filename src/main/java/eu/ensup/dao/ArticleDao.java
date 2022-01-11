package eu.ensup.dao;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import eu.ensup.domaine.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import javax.sql.DataSource;
import java.sql.*;

public class ArticleDao implements IDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Article get(String code) {
        String sql = "SELECT * FROM article WHERE code=?";
        Object[] obj = new Object[1];
        obj[0] = code;
        return this.jdbcTemplate.queryForObject(sql,(rs, rowNum) -> {
            Article article = new Article(
                    rs.getString("name"),
                    rs.getInt("quantity"),
                    rs.getFloat("price"),
                    rs.getString("category"),
                    rs.getString("code"));
            return article;
        },obj);
    }

    @Override
    public Integer create(Article article) {
        Object[] obj = new Object[5];
        obj[0] = article.getName();
        obj[1] = article.getQuantity();
        obj[2] = article.getPrice();
        obj[3] = article.getCategory();
        obj[4] = article.getCode();
        String sql = "INSERT INTO article(name, quantity, price, category, code) VALUES(?,?,?,?,?)";
        return this.jdbcTemplate.update(sql,obj);
    }

    @Override
    public Article update(Article article) {
        Object[] obj = new Object[5];
        obj[0] = article.getName();
        obj[1] = article.getQuantity();
        obj[2] = article.getPrice();
        obj[3] = article.getCategory();
        obj[4] = article.getCode();
        String sql = "UPDATE article SET name=?, quantity=?, price=?, category=? WHERE code=?";
        this.jdbcTemplate.update(sql,obj);
        return article;
    }

    @Override
    public Integer delete(String code) {
        System.out.println("DAO: Suppression de l'article " + code);
        return null;
    }

    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
