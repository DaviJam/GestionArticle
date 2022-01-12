package eu.ensup.beans;


import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.util.DriverDataSource;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")

public class DataSourceBeans {
    @Value("${spring.demo.userName}")
    String userName;
    @Value("${spring.demo.url}")
    String url;
    @Value("${spring.demo.password}")
    String password;



    @Bean
    public DataSource dataSource (){

        HikariDataSource hikariDataSource = new HikariDataSource();
           hikariDataSource.setUsername(userName);
           hikariDataSource.setPassword(password);
           hikariDataSource.setJdbcUrl(url);

        return hikariDataSource;
    }

}
