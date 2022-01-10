package eu.ensup.container;

import eu.ensup.dao.ArticleDao;
import eu.ensup.dao.ArticleDaoJpa;
import eu.ensup.service.ArticleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoBeansConfig {

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleService articleService() {
        return new ArticleService(articleDaoJpa());
    }

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleDao articleDao() {
        return new ArticleDao();
    }

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleDaoJpa articleDaoJpa() {
        return new ArticleDaoJpa();
    }

}
