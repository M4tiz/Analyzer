package org.analyzer.configuration.root;

import org.analyzer.constants.Constants;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = Constants.PERSISTENCE_PACKAGE)
@PropertySource("classpath:mysql.properties")
public class MySQLDataSourceConfiguration {

    private static final String MYSQL_DRIVER = "mysql.driver";
    private static final String MYSQL_URL = "mysql.url";
    private static final String MYSQL_USERNAME = "mysql.username";
    private static final String MYSQL_PASSWORD = "mysql.password";

    @Resource
    private Environment environment;

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource, JpaVendorAdapter vendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan(Constants.DOMAIN_PACKAGE);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setDatabasePlatform(org.hibernate.dialect.MySQLDialect.getDialect().toString());

        return vendorAdapter;
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory.getObject());

        return jpaTransactionManager;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(get(MYSQL_DRIVER));
        dataSource.setUrl(get(MYSQL_URL));
        dataSource.setPassword(get(MYSQL_PASSWORD));
        dataSource.setUsername( get(MYSQL_USERNAME) );

        return dataSource;
    }

    private String get(String key) {
        return environment.getRequiredProperty(key);
    }
}
