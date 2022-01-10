package eu.ensup.container;

import eu.ensup.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class BeansServiceConfig {

    @Autowired
    private BeansDaoConfig beansdaoconfig;

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleService articleService() {
        return new ArticleService(beansdaoconfig.articleDaoJpa());
    }
}
