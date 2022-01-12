package eu.ensup.beans;

import eu.ensup.dao.ArticleDao;
import eu.ensup.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeans {

    @Bean
    ArticleService articleService(){
        return new ArticleService();
    }
}
