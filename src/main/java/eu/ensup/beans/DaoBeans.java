package eu.ensup.beans;

import eu.ensup.dao.ArticleDao;
import eu.ensup.dao.ArticleDaoJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoBeans {
    @Bean
    public ArticleDao articleDao(){
        return new ArticleDao();
    }

    @Bean
    public ArticleDaoJpa articleDaoJpa(){
        return new ArticleDaoJpa();
    }
}
