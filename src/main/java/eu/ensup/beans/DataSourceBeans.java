package eu.ensup.beans;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceBeans {
    @Value("${mysql.user}")
    String user;
    @Value("${mysql.password}")
    String password;
    @Value("${mysql.url}")
    String url;

//    <bean id="datasource1"
//    class="org.springframework.jdbc.datasource.DriverManagerDataSource">
//		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
//		<property name="url" value="jdbc:mysql://localhost/formation" />
//		<property name="username" value="root" />
//		<property name="password" value="" />
//	</bean>
    @Bean
    public JdbcTemplate jdbcTemplate (){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource (){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUser(user);
        mysqlDataSource.setPassword(password);
        mysqlDataSource.setUrl(url);
        return mysqlDataSource;
    }

}
