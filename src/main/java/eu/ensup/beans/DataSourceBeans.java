package eu.ensup.beans;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DataSourceBeans {
//    <bean id="datasource1"
//    class="org.springframework.jdbc.datasource.DriverManagerDataSource">
//		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
//		<property name="url" value="jdbc:mysql://localhost/formation" />
//		<property name="username" value="root" />
//		<property name="password" value="" />
//	</bean>

    @Bean
    public DataSource dataSource (){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUser("spring");
        mysqlDataSource.setPassword("spring");
        mysqlDataSource.setUrl("jdbc:mysql://127.0.0.1:3309/gestionarticle");
        return mysqlDataSource;
    }

}
