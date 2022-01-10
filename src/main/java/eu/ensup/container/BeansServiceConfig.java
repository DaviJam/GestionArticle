package eu.ensup.container;

import eu.ensup.service.ArticleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeansDaoConfig.class)
public class BeansServiceConfig {
    private BeansDaoConfig demoBeansConfig;
    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleService articleService() {
        return new ArticleService(demoBeansConfig.articleDaoJpa());
    }
}
