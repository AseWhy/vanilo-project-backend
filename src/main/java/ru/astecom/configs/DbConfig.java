package ru.astecom.configs;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import java.util.Properties;

@Configuration
public class DbConfig {
    @Value("${hibernate.show_sql}")
    private Boolean showSql;
    @Value("${hibernate.format_sql}")
    private Boolean formatSql;
    @Value("${hibernate.use_sql_comments}")
    private Boolean useSqlComments;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.batch_size}")
    private Integer batchSize;
    @Value("${hibernate.max_pool_size}")
    private Integer maxPoolSize;
    @Value("${hibernate.schema}")
    private String schema;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Bean(name = "flyway")
    public Flyway flyway() {
        var fw = Flyway
            .configure()
            .schemas(schema)
        .dataSource(baseDataSource());

        if(activeProfile.contains("test")) {
            fw.locations("classpath:migration", "classpath:test");
        } else {
            fw.locations("classpath:migration");
        }

        var loaded = fw.load();

        if(activeProfile.contains("test")) {
            loaded.clean();
        }

        loaded.migrate();

        return loaded;
    }

    @Bean
    public HikariDataSource baseDataSource() {
        var ds = new HikariDataSource();

        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
        ds.setMaximumPoolSize(maxPoolSize);
        ds.setConnectionTestQuery("SELECT 1");

        return ds;
    }

    @Bean
    @Primary
    @DependsOn({"flyway"})
    public LocalSessionFactoryBean entityManagerFactory() {
        var properties = new Properties();

        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.use_sql_comments", useSqlComments);
        properties.put("hibernate.hbm2ddl.auto", "validate");
        properties.put("hibernate.jdbc.batch_size", batchSize);
        properties.put("hibernate.discriminator.force_in_select", true);
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.default_schema", schema);

        var sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(baseDataSource());
        sessionFactory.setPackagesToScan("ru.astecom.models");
        sessionFactory.setHibernateProperties(properties);

        return sessionFactory;
    }

    @Bean("transactionManager")
    public JpaTransactionManager transactionManager() {
        var tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory().getObject());
        tm.setTransactionSynchronization(AbstractPlatformTransactionManager.SYNCHRONIZATION_ALWAYS);
        tm.setDataSource(baseDataSource());
        return tm;
    }
}
